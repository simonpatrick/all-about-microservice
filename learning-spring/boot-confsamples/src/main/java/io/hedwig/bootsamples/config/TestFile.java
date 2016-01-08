package io.hedwig.bootsamples.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by patrick on 16/1/7.
 */
public class TestFile {

    static Pattern pattern = Pattern.compile("\\$");
    private Matcher m ;
    public void recordViolations(String path) {

        try {
            File file = new File(path);
            List<File> targetFolders = getTargetFolders(file);
            for (File target : targetFolders) {
                System.out.println("start scan target file "+target.getAbsolutePath());
                scanForSQLViolation(targetFolders.get(4));
            }
        } catch (Exception e) {
        }
    }

    private void scanForSQLViolation(File file) {
        if (file.isDirectory()) {
            if (isTargetFolderToScan(file)) {// filter /com folder
                File[] files = file.listFiles();
                for (File f : files) {
                    scanForSQLViolation( f);
                }
            }
        } else {
            recordViolation(file);
        }
    }

    /**
     * 获取Jenkins 指定workspace下面的所有target class 目录
     *
     * @param file
     * @return
     */
    private List<File> getTargetFolders(File file) {
        List<File> targetFiles = new ArrayList<File>();
        if (file.isDirectory() && file.exists()) { //workspace is existing

            File[] files = file.listFiles();
            for (File sub : files) {
                if (sub.isDirectory()) {
                    if(sub.getName().equalsIgnoreCase("target")){
                        File target = new File(sub.getAbsolutePath() + "/classes");
                        if(target.exists()){
                            targetFiles.add(target);
                        }
                    }else{
                        File target = new File(sub.getAbsolutePath() + "/target/classes");
                        if (target.exists()) {
                            if (file.isDirectory()) {
                                targetFiles.add(target);
                            }
                        }
                    }
                }
            }
        }

        return targetFiles;
    }

    /**
     * 检查是否是需要检查的目录
     *
     * @param file
     * @return
     */
    private boolean isTargetFolderToScan(File file) {
        return !file.getName().equalsIgnoreCase("com") &&!file.getName().equalsIgnoreCase("io");
    }

    /**
     * 扫描单个文件的SQL
     * @param file
     * @param listener
     */
    private void recordViolation(File file) {

        if (file.getName().toUpperCase().contains(".XML")) {
            long current = System.currentTimeMillis();
            List<Node> nodes = getSqlMapperNodes(file.getAbsolutePath());
            long endReadNodes = System.currentTimeMillis();
            System.out.println("read nodes time "+ String.valueOf(endReadNodes-current));

            current=System.currentTimeMillis();
            for (Object node : nodes) {
                List<Element> children = ((Element) node).elements();
                for (Element child : children) {
//                    if (child.getQName().getName().contains("select")) {
//                        //process with(nolock)
//                    }
                    m = pattern.matcher(child.getText());
                    if (m.find()) {
                        System.out.println("start scan file:"+file.getAbsoluteFile());
                        System.out.println("error is "+child.getText());
                    }
                }
            }
            endReadNodes = System.currentTimeMillis();
            System.out.println("find validation time: "+ String.valueOf(endReadNodes-current));
        }
    }



    /**
     * 获取SQL MAPPER 文件中的节点
     * @param path
     * @return
     */
    public List getSqlMapperNodes(String path) {
        try {
            Document document = new SAXReader(false).read(path);
            return document.selectNodes("//mapper | //sqlMap");
        } catch (DocumentException e) {
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        new TestFile().recordViolations("/Users/patrick/workspace/works/self-repos/all-about-microservice/learning-spring");
        long endReadNodes = System.currentTimeMillis();
        System.out.println("read nodes time "+ String.valueOf(endReadNodes-current));

    }
}
