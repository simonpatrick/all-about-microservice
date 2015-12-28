package io.hedwig.wings.casebuilder.samples.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;

@ConfigurationProperties("hello")
public class HelloProperties {

    /**
     * Prefix of the welcome message.
     */
    private String prefix = "Hello";

    /**
     * Suffix of the welcome message.
     */
    @NotNull
    private String name;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Deprecated
    @DeprecatedConfigurationProperty(reason = "lousy name", replacement = "hello.name")
    public String getTarget() {
        return getName();
    }

    @Deprecated
    public void setTarget(String target) {
        setName(target);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}