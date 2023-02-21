package configs;

@RemoteConfig.LoadPolicy(RemoteConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:params/android_browserstack.properties",
                "classpath:params/android_browserstack_credentials.properties"})
public interface RemoteConfig extends org.aeonbits.owner.Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

}
