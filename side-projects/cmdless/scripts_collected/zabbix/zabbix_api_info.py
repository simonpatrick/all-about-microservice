import requests

json_request = """{
    "jsonrpc": "2.0",
    "method": "apiinfo.version",
    "params": [],
    "id": 1
}"""

login_data = """{
    "jsonrpc": "2.0",
    "method": "user.login",
    "params": {
        "user": "110863",
        "password": "123456"
    },
    "id": 1,
    "auth": null
}"""

host_get = """
{
    "jsonrpc": "2.0",
    "method": "host.get",
    "params": {
        "output": [
            "hostid",
            "host"
        ],
        "selectInterfaces": [
            "interfaceid",
            "ip"
        ]
    },
    "id": 2,
    "auth": "36007d191f125feecbef8186b4df0df6"
}
"""
url = 'http://java.zabbix.dooioo.com/api_jsonrpc.php'
header = {
    "Content-Type": "application/json-rpc"
}

'{"jsonrpc":"2.0","result":"36007d191f125feecbef8186b4df0df6","id":1}'
content = requests.post(url, data=host_get, headers=header)
content.json()
print(content.text)

json_host_id = """
{"jsonrpc": "2.0", "result": [{"hostid": "10110", "host": "192.168.0.119-api-10006",
                               "interfaces": [{"interfaceid": "7", "ip": "192.168.0.119"}]},
                              {"hostid": "10112", "host": "192.168.0.122-10013-guanggao",
                               "interfaces": [{"interfaceid": "9", "ip": "192.168.0.122"}]},
                              {"hostid": "10113", "host": "192.168.0.122-duanxin-10012",
                               "interfaces": [{"interfaceid": "10", "ip": "192.168.0.122"}]},
                              {"hostid": "10114", "host": "192.168.0.122-tuiguang-10011",
                               "interfaces": [{"interfaceid": "11", "ip": "192.168.0.122"}]},
                              {"hostid": "10116", "host": "10.22.16.173-ljk-17082",
                               "interfaces": [{"interfaceid": "13", "ip": "10.22.16.173"}]},
                              {"hostid": "10117", "host": "10.22.16.172-send-17081",
                               "interfaces": [{"interfaceid": "14", "ip": "10.22.16.172"}]},
                              {"hostid": "10121", "host": "192.168.0.135-fy-10011",
                               "interfaces": [{"interfaceid": "18", "ip": "192.168.0.135"}]},
                              {"hostid": "10126", "host": "192.168.0.141-adv-12346",
                               "interfaces": [{"interfaceid": "23", "ip": "192.168.0.141"}]},
                              {"hostid": "10127", "host": "192.168.0.182-1090-zuzhishu",
                               "interfaces": [{"interfaceid": "24", "ip": "192.168.0.182"}]},
                              {"hostid": "10128", "host": "192.168.0.182-5560-zzjg",
                               "interfaces": [{"interfaceid": "25", "ip": "192.168.0.182"}]},
                              {"hostid": "10129", "host": "192.168.0.182-5850-renzi",
                               "interfaces": [{"interfaceid": "26", "ip": "192.168.0.182"}]},
                              {"hostid": "10131", "host": "192.168.0.182-7780-zhaopin",
                               "interfaces": [{"interfaceid": "28", "ip": "192.168.0.182"}]},
                              {"hostid": "10132", "host": "192.168.0.183-5080-peixun",
                               "interfaces": [{"interfaceid": "29", "ip": "192.168.0.183"}]},
                              {"hostid": "10133", "host": "192.168.0.183-8810-gongzi",
                               "interfaces": [{"interfaceid": "30", "ip": "192.168.0.183"}]},
                              {"hostid": "10134", "host": "192.168.0.183-5190-wenshu",
                               "interfaces": [{"interfaceid": "31", "ip": "192.168.0.183"}]},
                              {"hostid": "10135", "host": "192.168.0.183-8880-kaoqin",
                               "interfaces": [{"interfaceid": "32", "ip": "192.168.0.183"}]},
                              {"hostid": "10136", "host": "192.168.0.184-6030-supplier",
                               "interfaces": [{"interfaceid": "33", "ip": "192.168.0.184"}]},
                              {"hostid": "10137", "host": "192.168.0.184-6900-mingpian",
                               "interfaces": [{"interfaceid": "34", "ip": "192.168.0.184"}]},
                              {"hostid": "10138", "host": "192.168.0.184-7430-xiongpai",
                               "interfaces": [{"interfaceid": "35", "ip": "192.168.0.184"}]},
                              {"hostid": "10147", "host": "10.22.16.70-9900quanzhanxiaoxi",
                               "interfaces": [{"interfaceid": "44", "ip": "10.22.16.70"}]},
                              {"hostid": "10150", "host": "10.22.16.70-gzz-8188",
                               "interfaces": [{"interfaceid": "47", "ip": "10.22.16.70"}]},
                              {"hostid": "10151", "host": "192.168.0.207-lp-9999",
                               "interfaces": [{"interfaceid": "48", "ip": "192.168.0.207"}]},
                              {"hostid": "10154", "host": "192.168.0.147-jiaoyi-18686",
                               "interfaces": [{"interfaceid": "51", "ip": "192.168.0.147"}]},
                              {"hostid": "10155", "host": "192.168.0.210-shly-18050",
                               "interfaces": [{"interfaceid": "52", "ip": "192.168.0.210"}]},
                              {"hostid": "10156", "host": "192.168.0.210-zhengxin-18010",
                               "interfaces": [{"interfaceid": "53", "ip": "192.168.0.210"}]},
                              {"hostid": "10157", "host": "192.168.0.214-ky-7080",
                               "interfaces": [{"interfaceid": "54", "ip": "192.168.0.214"}]},
                              {"hostid": "10161", "host": "10.22.16.71-gzz-8188",
                               "interfaces": [{"interfaceid": "58", "ip": "10.22.16.71"}]},
                              {"hostid": "10162", "host": "10.22.16.71-9900-quanzhanxiaoxi",
                               "interfaces": [{"interfaceid": "59", "ip": "10.22.16.71"}]},
                              {"hostid": "10165", "host": "192.168.0.148-jiaoyi-18686",
                               "interfaces": [{"interfaceid": "62", "ip": "192.168.0.148"}]},
                              {"hostid": "10166", "host": "192.168.0.225-ky-7080",
                               "interfaces": [{"interfaceid": "63", "ip": "192.168.0.225"}]},
                              {"hostid": "10169", "host": "192.168.0.235-shouhou-17070",
                               "interfaces": [{"interfaceid": "66", "ip": "192.168.0.235"}]},
                              {"hostid": "10170", "host": "192.168.0.235-wdjy-18010",
                               "interfaces": [{"interfaceid": "67", "ip": "192.168.0.235"}]},
                              {"hostid": "10171", "host": "192.168.0.217-lp-9999",
                               "interfaces": [{"interfaceid": "68", "ip": "192.168.0.217"}]},
                              {"hostid": "10175", "host": "192.168.0.184-8880-kaoqin",
                               "interfaces": [{"interfaceid": "72", "ip": "192.168.0.184"}]},
                              {"hostid": "10178", "host": "192.168.0.167-zichan-9001",
                               "interfaces": [{"interfaceid": "75", "ip": "192.168.0.167"}]},
                              {"hostid": "10179", "host": "192.168.0.168-zichan-9001",
                               "interfaces": [{"interfaceid": "76", "ip": "192.168.0.168"}]},
                              {"hostid": "10182", "host": "192.168.0.141-telproxy-10890",
                               "interfaces": [{"interfaceid": "79", "ip": "192.168.0.141"}]},
                              {"hostid": "10184", "host": "192.168.0.162-yishou-19090",
                               "interfaces": [{"interfaceid": "81", "ip": "192.168.0.162"}]},
                              {"hostid": "10185", "host": "192.168.0.163-yishou-19090",
                               "interfaces": [{"interfaceid": "82", "ip": "192.168.0.163"}]},
                              {"hostid": "10186", "host": "192.168.0.182-3850-renziapi",
                               "interfaces": [{"interfaceid": "83", "ip": "192.168.0.182"}]},
                              {"hostid": "10187", "host": "192.168.0.187-3850-renziapi",
                               "interfaces": [{"interfaceid": "84", "ip": "192.168.0.187"}]},
                              {"hostid": "10188", "host": "192.168.0.137-fy-10011",
                               "interfaces": [{"interfaceid": "85", "ip": "192.168.0.137"}]},
                              {"hostid": "10189", "host": "192.168.0.149-fy-10011",
                               "interfaces": [{"interfaceid": "86", "ip": "192.168.0.149"}]},
                              {"hostid": "10190", "host": "192.168.0.185-8880-kaoqin",
                               "interfaces": [{"interfaceid": "87", "ip": "192.168.0.185"}]},
                              {"hostid": "10193", "host": "192.168.0.208-data-10014",
                               "interfaces": [{"interfaceid": "90", "ip": "192.168.0.208"}]},
                              {"hostid": "10194", "host": "10.22.16.40-fy",
                               "interfaces": [{"interfaceid": "91", "ip": "10.22.16.40"}]},
                              {"hostid": "10195", "host": "10.22.16.41-fy",
                               "interfaces": [{"interfaceid": "92", "ip": "10.22.16.41"}]},
                              {"hostid": "10196", "host": "10.22.16.42-fy",
                               "interfaces": [{"interfaceid": "93", "ip": "10.22.16.42"}]},
                              {"hostid": "10197", "host": "10.22.16.43-fy",
                               "interfaces": [{"interfaceid": "94", "ip": "10.22.16.43"}]},
                              {"hostid": "10198", "host": "10.22.16.170-send-17081",
                               "interfaces": [{"interfaceid": "95", "ip": "10.22.16.170"}]},
                              {"hostid": "10199", "host": "10.22.16.171-ljk-17082",
                               "interfaces": [{"interfaceid": "96", "ip": "10.22.16.171"}]},
                              {"hostid": "10200", "host": "10.22.16.160-ky-7080",
                               "interfaces": [{"interfaceid": "97", "ip": "10.22.16.160"}]},
                              {"hostid": "10201", "host": "10.22.16.120-shly-18050",
                               "interfaces": [{"interfaceid": "98", "ip": "10.22.16.120"}]},
                              {"hostid": "10202", "host": "10.22.16.120-shouhou-17070",
                               "interfaces": [{"interfaceid": "99", "ip": "10.22.16.120"}]},
                              {"hostid": "10203", "host": "192.168.0.182-5570-zzjgapi",
                               "interfaces": [{"interfaceid": "100", "ip": "192.168.0.182"}]},
                              {"hostid": "10204", "host": "192.168.0.122-webtask8080",
                               "interfaces": [{"interfaceid": "101", "ip": "192.168.0.122"}]},
                              {"hostid": "10205", "host": "192.168.0.165-10011-yezhuzhongxin",
                               "interfaces": [{"interfaceid": "102", "ip": "192.168.0.165"}]},
                              {"hostid": "10206", "host": "192.168.0.166-10011-yezhuzhongxin",
                               "interfaces": [{"interfaceid": "103", "ip": "192.168.0.166"}]},
                              {"hostid": "10207", "host": "10.22.16.101-feiyong-9101",
                               "interfaces": [{"interfaceid": "104", "ip": "10.22.16.101"}]},
                              {"hostid": "10208", "host": "10.22.16.100-feiyong-9101",
                               "interfaces": [{"interfaceid": "105", "ip": "10.22.16.100"}]},
                              {"hostid": "10210", "host": "10.22.16.73-blog-9901",
                               "interfaces": [{"interfaceid": "107", "ip": "10.22.16.73"}]},
                              {"hostid": "10211", "host": "10.22.16.75-blog-9901",
                               "interfaces": [{"interfaceid": "108", "ip": "10.22.16.75"}]},
                              {"hostid": "10212", "host": "192.168.0.187-5570-zzjgapi",
                               "interfaces": [{"interfaceid": "109", "ip": "192.168.0.187"}]},
                              {"hostid": "10213", "host": "10.22.16.121-jiaoyi-18686",
                               "interfaces": [{"interfaceid": "110", "ip": "10.22.16.121"}]},
                              {"hostid": "10215", "host": "10.22.16.195-9000-youjian",
                               "interfaces": [{"interfaceid": "112", "ip": "10.22.16.195"}]},
                              {"hostid": "10216", "host": "10.22.16.15-data-10014",
                               "interfaces": [{"interfaceid": "113", "ip": "10.22.16.15"}]},
                              {"hostid": "10217", "host": "10.22.16.44-fy",
                               "interfaces": [{"interfaceid": "114", "ip": "10.22.16.44"}]},
                              {"hostid": "10218", "host": "192.168.0.106-8088-login",
                               "interfaces": [{"interfaceid": "115", "ip": "192.168.0.106"}]},
                              {"hostid": "10219", "host": "192.168.0.108-8088-login",
                               "interfaces": [{"interfaceid": "116", "ip": "192.168.0.108"}]},
                              {"hostid": "10220", "host": "192.168.0.110-19091-keybox",
                               "interfaces": [{"interfaceid": "117", "ip": "192.168.0.110"}]},
                              {"hostid": "10221", "host": "192.168.0.103-19091-keybox",
                               "interfaces": [{"interfaceid": "118", "ip": "192.168.0.103"}]},
                              {"hostid": "10222", "host": "192.168.0.112-19091-keybox",
                               "interfaces": [{"interfaceid": "119", "ip": "192.168.0.112"}]},
                              {"hostid": "10223", "host": "192.168.0.115-19091-keybox",
                               "interfaces": [{"interfaceid": "120", "ip": "192.168.0.115"}]},
                              {"hostid": "10224", "host": "10.22.16.12-data-10014",
                               "interfaces": [{"interfaceid": "121", "ip": "10.22.16.12"}]},
                              {"hostid": "10225", "host": "10.22.16.12-crawler-10011",
                               "interfaces": [{"interfaceid": "122", "ip": "10.22.16.12"}]},
                              {"hostid": "10226", "host": "10.22.16.13-sheyinshipingtai-10011",
                               "interfaces": [{"interfaceid": "123", "ip": "10.22.16.13"}]},
                              {"hostid": "10227", "host": "10.22.16.14-data-10014",
                               "interfaces": [{"interfaceid": "124", "ip": "10.22.16.14"}]},
                              {"hostid": "10228", "host": "10.22.16.16-tuiguang-10011",
                               "interfaces": [{"interfaceid": "125", "ip": "10.22.16.16"}]},
                              {"hostid": "10229", "host": "10.22.16.17-sheyinshipingtai-10011",
                               "interfaces": [{"interfaceid": "126", "ip": "10.22.16.17"}]},
                              {"hostid": "10230", "host": "10.22.16.70-9910xiaoxihoutai",
                               "interfaces": [{"interfaceid": "127", "ip": "10.22.16.70"}]},
                              {"hostid": "10231", "host": "10.22.16.71-9910xiaoxihoutai",
                               "interfaces": [{"interfaceid": "128", "ip": "10.22.16.71"}]},
                              {"hostid": "10232", "host": "10.22.16.72--9199--help",
                               "interfaces": [{"interfaceid": "129", "ip": "10.22.16.72"}]},
                              {"hostid": "10233", "host": "10.22.16.72-helpbak-2124",
                               "interfaces": [{"interfaceid": "130", "ip": "10.22.16.72"}]},
                              {"hostid": "10234", "host": "10.22.16.74-yisouwap-12345",
                               "interfaces": [{"interfaceid": "131", "ip": "10.22.16.74"}]},
                              {"hostid": "10235", "host": "10.22.16.80-10013-dzj",
                               "interfaces": [{"interfaceid": "132", "ip": "10.22.16.80"}]},
                              {"hostid": "10236", "host": "10.22.16.181-zdf-18322",
                               "interfaces": [{"interfaceid": "133", "ip": "10.22.16.181"}]},
                              {"hostid": "10237", "host": "10.22.16.195-7930-migrate",
                               "interfaces": [{"interfaceid": "134", "ip": "10.22.16.195"}]},
                              {"hostid": "10238", "host": "192.168.0.106-10106-mailsync",
                               "interfaces": [{"interfaceid": "135", "ip": "192.168.0.106"}]},
                              {"hostid": "10239", "host": "192.168.0.141-14107-400tel",
                               "interfaces": [{"interfaceid": "136", "ip": "192.168.0.141"}]},
                              {"hostid": "10240", "host": "192.168.0.145-8081-telproxy",
                               "interfaces": [{"interfaceid": "137", "ip": "192.168.0.145"}]},
                              {"hostid": "10241", "host": "192.168.0.146-8081-telproxy",
                               "interfaces": [{"interfaceid": "138", "ip": "192.168.0.146"}]},
                              {"hostid": "10242", "host": "192.168.0.167-synceas-12201",
                               "interfaces": [{"interfaceid": "139", "ip": "192.168.0.167"}]},
                              {"hostid": "10243", "host": "192.168.0.168-synceas-12201",
                               "interfaces": [{"interfaceid": "140", "ip": "192.168.0.168"}]},
                              {"hostid": "10244", "host": "192.168.0.169-10013-guanggao",
                               "interfaces": [{"interfaceid": "141", "ip": "192.168.0.169"}]},
                              {"hostid": "10245", "host": "192.168.0.173-8029-dyapp",
                               "interfaces": [{"interfaceid": "142", "ip": "192.168.0.173"}]},
                              {"hostid": "10246", "host": "192.168.0.173-8019-dypns",
                               "interfaces": [{"interfaceid": "143", "ip": "192.168.0.173"}]},
                              {"hostid": "10248", "host": "192.168.0.223-sunyi-6561",
                               "interfaces": [{"interfaceid": "145", "ip": "192.168.0.223"}]},
                              {"hostid": "10249", "host": "192.168.0.224-xingcheng-10002",
                               "interfaces": [{"interfaceid": "146", "ip": "192.168.0.224"}]},
                              {"hostid": "10250", "host": "192.168.0.227-400tel-14345",
                               "interfaces": [{"interfaceid": "147", "ip": "192.168.0.227"}]},
                              {"hostid": "10251", "host": "192.168.0.230-adv-12346",
                               "interfaces": [{"interfaceid": "148", "ip": "192.168.0.230"}]},
                              {"hostid": "10252", "host": "192.168.0.230-telproxy-10890",
                               "interfaces": [{"interfaceid": "149", "ip": "192.168.0.230"}]},
                              {"hostid": "10254", "host": "192.168.0.232-telproxy-10890",
                               "interfaces": [{"interfaceid": "151", "ip": "192.168.0.232"}]},
                              {"hostid": "10255", "host": "192.168.0.236-cad-9999",
                               "interfaces": [{"interfaceid": "152", "ip": "192.168.0.236"}]},
                              {"hostid": "10256", "host": "192.168.0.236-sheyingshi-19999",
                               "interfaces": [{"interfaceid": "153", "ip": "192.168.0.236"}]},
                              {"hostid": "10257", "host": "10.22.1.51-fysolr-18011",
                               "interfaces": [{"interfaceid": "154", "ip": "10.22.1.51"}]},
                              {"hostid": "10258", "host": "10.22.1.52-fysolr-18011",
                               "interfaces": [{"interfaceid": "155", "ip": "10.22.1.52"}]},
                              {"hostid": "10259", "host": "10.22.1.53-fysolr-18011",
                               "interfaces": [{"interfaceid": "156", "ip": "10.22.1.53"}]},
                              {"hostid": "10260", "host": "192.168.0.203-fysolr-18011",
                               "interfaces": [{"interfaceid": "157", "ip": "192.168.0.203"}]},
                              {"hostid": "10261", "host": "10.22.16.122-jiaoyi-18686",
                               "interfaces": [{"interfaceid": "158", "ip": "10.22.16.122"}]},
                              {"hostid": "10262", "host": "10.22.16.123-jiaoyi-18686",
                               "interfaces": [{"interfaceid": "159", "ip": "10.22.16.123"}]},
                              {"hostid": "10263", "host": "192.168.0.119-support-10007",
                               "interfaces": [{"interfaceid": "160", "ip": "192.168.0.119"}]},
                              {"hostid": "10264", "host": "192.168.0.119-sync-10003",
                               "interfaces": [{"interfaceid": "161", "ip": "192.168.0.119"}]},
                              {"hostid": "10265", "host": "192.168.0.139-inquiry-17011",
                               "interfaces": [{"interfaceid": "162", "ip": "192.168.0.139"}]},
                              {"hostid": "10266", "host": "192.168.0.140-inquiry-17011",
                               "interfaces": [{"interfaceid": "163", "ip": "192.168.0.140"}]},
                              {"hostid": "10267", "host": "192.168.0.220-eds-15011",
                               "interfaces": [{"interfaceid": "164", "ip": "192.168.0.220"}]},
                              {"hostid": "10268", "host": "192.168.3.38",
                               "interfaces": [{"interfaceid": "165", "ip": "192.168.3.38"}]},
                              {"hostid": "10269", "host": "10.22.1.54-inquiry-17011",
                               "interfaces": [{"interfaceid": "166", "ip": "10.22.1.54"}]},
                              {"hostid": "10270", "host": "10.22.1.55-inquiry-17011",
                               "interfaces": [{"interfaceid": "167", "ip": "10.22.1.55"}]},
                              {"hostid": "10271", "host": "10.22.1.201-soldhouse-18333",
                               "interfaces": [{"interfaceid": "168", "ip": "10.22.1.201"}]},
                              {"hostid": "10272", "host": "10.22.16.18-data-10014",
                               "interfaces": [{"interfaceid": "169", "ip": "10.22.16.18"}]},
                              {"hostid": "10273", "host": "192.168.0.223-bird-8179",
                               "interfaces": [{"interfaceid": "170", "ip": "192.168.0.223"}]},
                              {"hostid": "10274", "host": "192.168.0.219-beian-7071",
                               "interfaces": [{"interfaceid": "171", "ip": "192.168.0.219"}]},
                              {"hostid": "10275", "host": "192.168.0.185-3850-renziapi",
                               "interfaces": [{"interfaceid": "172", "ip": "192.168.0.185"}]},
                              {"hostid": "10276", "host": "192.168.0.185-5570-zzjgapi",
                               "interfaces": [{"interfaceid": "173", "ip": "192.168.0.185"}]},
                              {"hostid": "10277", "host": "10.22.16.19-9900quanzhanxiaoxi",
                               "interfaces": [{"interfaceid": "174", "ip": "10.22.16.19"}]},
                              {"hostid": "10278", "host": "10.22.16.19-9910xiaoxihoutai",
                               "interfaces": [{"interfaceid": "175", "ip": "10.22.16.19"}]},
                              {"hostid": "10279", "host": "10.22.16.20-9900quanzhanxiaoxi",
                               "interfaces": [{"interfaceid": "176", "ip": "10.22.16.20"}]},
                              {"hostid": "10280", "host": "10.22.16.20-9910xiaoxihoutai",
                               "interfaces": [{"interfaceid": "177", "ip": "10.22.16.20"}]},
                              {"hostid": "10281", "host": "192.168.0.185-8870-kaoqinapi",
                               "interfaces": [{"interfaceid": "178", "ip": "192.168.0.185"}]},
                              {"hostid": "10282", "host": "192.168.0.187-8870-kaoqinapi",
                               "interfaces": [{"interfaceid": "179", "ip": "192.168.0.187"}]},
                              {"hostid": "10283", "host": "10.22.16.81-10013-dzj",
                               "interfaces": [{"interfaceid": "180", "ip": "10.22.16.81"}]},
                              {"hostid": "10284", "host": "192.168.0.121-wirelessbill-10013",
                               "interfaces": [{"interfaceid": "181", "ip": "192.168.0.121"}]},
                              {"hostid": "10285", "host": "192.168.0.124-wirelessbill-10013",
                               "interfaces": [{"interfaceid": "182", "ip": "192.168.0.124"}]},
                              {"hostid": "10286", "host": "192.168.0.135-yunying-10012",
                               "interfaces": [{"interfaceid": "183", "ip": "192.168.0.135"}]},
                              {"hostid": "10287", "host": "10.22.16.124-jinrong-8011",
                               "interfaces": [{"interfaceid": "184", "ip": "10.22.16.124"}]},
                              {"hostid": "10288", "host": "10.22.16.125-jinrong-8011",
                               "interfaces": [{"interfaceid": "185", "ip": "10.22.16.125"}]},
                              {"hostid": "10289", "host": "192.168.0.98-openapi-8081",
                               "interfaces": [{"interfaceid": "186", "ip": "192.168.0.98"}]},
                              {"hostid": "10290", "host": "192.168.0.99-openapi-8081",
                               "interfaces": [{"interfaceid": "187", "ip": "192.168.0.99"}]},
                              {"hostid": "10291", "host": "10.22.16.200-9600-ms",
                               "interfaces": [{"interfaceid": "188", "ip": "10.22.16.200"}]},
                              {"hostid": "10292", "host": "10.22.16.201-9600-ms",
                               "interfaces": [{"interfaceid": "189", "ip": "10.22.16.201"}]},
                              {"hostid": "10293", "host": "10.22.1.54-help-14011",
                               "interfaces": [{"interfaceid": "190", "ip": "10.22.1.54"}]},
                              {"hostid": "10294", "host": "10.22.1.55-help-14011",
                               "interfaces": [{"interfaceid": "191", "ip": "10.22.1.55"}]},
                              {"hostid": "10295", "host": "10.22.16.58-dianhua-18090",
                               "interfaces": [{"interfaceid": "192", "ip": "10.22.16.58"}]},
                              {"hostid": "10296", "host": "10.22.16.59-dianhua-18090",
                               "interfaces": [{"interfaceid": "193", "ip": "10.22.16.59"}]},
                              {"hostid": "10297", "host": "10.22.16.192-weixinsync-1230",
                               "interfaces": [{"interfaceid": "194", "ip": "10.22.16.192"}]},
                              {"hostid": "10298", "host": "10.22.1.52-estate-16011",
                               "interfaces": [{"interfaceid": "195", "ip": "10.22.1.52"}]},
                              {"hostid": "10299", "host": "10.22.1.53-estate-16011",
                               "interfaces": [{"interfaceid": "196", "ip": "10.22.1.53"}]},
                              {"hostid": "10300", "host": "10.22.1.52-es-9100",
                               "interfaces": [{"interfaceid": "197", "ip": "10.22.1.52"}]},
                              {"hostid": "10301", "host": "10.22.1.53-es-9100",
                               "interfaces": [{"interfaceid": "198", "ip": "10.22.1.53"}]},
                              {"hostid": "10302", "host": "10.22.1.56-es-9100",
                               "interfaces": [{"interfaceid": "199", "ip": "10.22.1.56"}]},
                              {"hostid": "10303", "host": "10.22.1.57-es-9100",
                               "interfaces": [{"interfaceid": "200", "ip": "10.22.1.57"}]},
                              {"hostid": "10304", "host": "10.22.16.83-9199-bangzhu",
                               "interfaces": [{"interfaceid": "201", "ip": "10.22.16.83"}]},
                              {"hostid": "10305", "host": "10.22.16.82-2124-bangzhusp",
                               "interfaces": [{"interfaceid": "202", "ip": "10.22.16.82"}]},
                              {"hostid": "10306", "host": "10.22.16.161-eds-8090",
                               "interfaces": [{"interfaceid": "204", "ip": "10.22.16.161"}]},
                              {"hostid": "10307", "host": "10.22.16.193-8880-kaoqin",
                               "interfaces": [{"interfaceid": "205", "ip": "10.22.16.193"}]}],
 "id": 2}
"""
