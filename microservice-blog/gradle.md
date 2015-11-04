```java
group 'io.hedwig'
version '0.1-SNAPSHOT'

apply plugin: 'groovy'
apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'spring-boot'

sourceCompatibility = 1.8
targetCompatibility = 1.8


repositories {
    mavenLocal()
    jcenter()
    mavenCentral()

    maven { url 'http://repo.spring.io/libs-release' }
    maven { url "http://repo.springsource.org/repo" }
}

buildscript {
    ext {
        springBootVersion='1.2.7.RELEASE'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

dependencies {
    compile 'org.codehaus.groovy:groovy-all:2.3.11'
    // tag::jetty[]
    compile("org.springframework.boot:spring-boot-starter-web:1.3.0.M5") {
        exclude module: "spring-boot-starter-tomcat"
    }
    compile("org.springframework.boot:spring-boot-starter-jetty")
    // end::jetty[]
    // tag::actuator[]
    compile("org.springframework.boot:spring-boot-starter-actuator")
    // end::actuator[]
    // spring boot
//    compile "org.springframework.boot:spring-boot-starter-web:1.3.0.M5"
//    compile "org.springframework.boot:spring-boot-starter-jetty"
//    compile "org.springframework.boot:spring-boot-starter-thymeleaf"
//    compile "com.domingosuarez.boot:spring-boot-starter-jade4j:0.3.1"
    compile "org.springframework.boot:spring-boot-starter-redis"
    compile(group: 'org.springframework.boot', name: 'spring-boot-starter', version:'1.3.0.M5') {
        exclude(module: 'spring-boot-starter-logging')
    }
    compile 'org.springframework.boot:spring-boot-starter-log4j:1.3.0.M5'
    compile 'org.springframework.boot:spring-boot-starter-data-jpa:1.3.0.M5'
    compile 'org.springframework.boot:spring-boot-starter-security:1.3.0.M5'

    // spring framework
    compile 'org.springframework:spring-context:4.2.1.RELEASE'
    compile 'org.springframework:spring-webmvc:4.1.7.RELEASE'
    compile 'org.springframework.security:spring-security-config:3.2.7.RELEASE'
    compile 'org.springframework.security:spring-security-web:3.2.7.RELEASE'

    //persistence
    compile 'com.zaxxer:HikariCP:+'
    compile 'org.springframework:spring-orm:+'
    compile 'org.hibernate:hibernate-entitymanager:+'
    compile 'javax.el:javax.el-api:+'
    compile 'org.hsqldb:hsqldb:+'

    // view
//    compile 'de.neuland-bfi:spring-jade4j:0.4.2'
    compile 'org.pegdown:pegdown:1.6.0'

    // python
    compile 'org.python:jython-standalone:2.7.0'
    compile 'org.pygments:pygments:2.0.2'

    // spring data
    compile 'org.springframework.data:spring-data-jpa:+'

    // cache
    compile 'org.springframework.data:spring-data-redis:1.6.0.RELEASE'
    compile 'redis.clients:jedis:2.7.3'

    // MySQL
    compile 'mysql:mysql-connector-java:+'

    // Validation
    compile 'org.hibernate:hibernate-validator:+'

    // Logging
    compile 'ch.qos.logback:logback-classic:1.1.3'
    compile 'org.slf4j:slf4j-api:+'
    compile 'org.apache.commons:commons-lang3:+'

    // @Inject
    compile 'javax.inject:javax.inject:+'

    // JSON
    compile 'com.fasterxml.jackson.core:jackson-databind:2.4.1.3'
    compile 'com.fasterxml.jackson.core:jackson-annotations:2.4.1'

    // Utilities
    compile 'com.google.guava:guava:+'
    compile 'org.modelmapper:modelmapper:0.7.5'
//    compile 'org.projectlombok:lombok:1.16.6'
    //compile 'com.qiniu:qiniu-java-sdk:7.0.+'


    // static resources, ref. http://www.webjars.org/
    compile 'org.webjars:jquery:2.1.4'
    compile 'org.webjars:bootstrap:3.3.5'
    compile 'org.webjars:font-awesome:4.3.0-3'
    compile 'org.webjars:ace:1.2.0'

    //test part
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile 'junit:junit:+'
    testCompile 'org.mockito:mockito-core:+'
    testCompile 'org.assertj:assertj-core:+'
    testCompile 'org.hamcrest:hamcrest-core:+'
    testCompile 'org.hamcrest:hamcrest-library:+'
    testCompile 'org.objenesis:objenesis:+'
    testCompile 'org.springframework:spring-test:+'
}

//create java dirs
task "jmkdirs" << {
    sourceSets*.java.srcDirs*.each { it.mkdirs() }
    sourceSets*.resources.srcDirs*.each { it.mkdirs() }
}
```