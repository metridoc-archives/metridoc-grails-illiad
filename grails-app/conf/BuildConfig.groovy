grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.repos.metridocRepo.url = "https://metridoc.googlecode.com/svn/plugins"
grails.project.repos.default = "metridocRepo"

grails.project.dependency.resolution = {


    grails.tomcat.jvmArgs = ["-Xmx768M", "-Xms768M", "-XX:PermSize=512m", "-XX:MaxPermSize=512m"]
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        grailsPlugins()
        grailsHome()
        grailsRepo "https://metridoc.googlecode.com/svn/plugins/"
    }

    dependencies {
        //makes the plugin play nice with Intellij
        compile("org.liquibase:liquibase-core:2.0.5")
        build("org.tmatesoft.svnkit:svnkit:1.3.5") {
            excludes "jna", "trilead-ssh2", "sqljet"
        }
    }

    plugins {
        compile(":metridoc-core:0.53-SNAPSHOT")
        build ":tomcat:$grailsVersion"
        build ":rest-client-builder:1.0.2"
        build ":release:$grailsVersion"
        build ":svn:1.0.2"
    }
}
