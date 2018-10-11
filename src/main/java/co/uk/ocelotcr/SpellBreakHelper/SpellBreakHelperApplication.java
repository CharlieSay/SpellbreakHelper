package co.uk.ocelotcr.SpellBreakHelper;

import co.uk.ocelotcr.SpellBreakHelper.Config.Config;
import co.uk.ocelotcr.SpellBreakHelper.Config.LiveConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

    @SpringBootApplication
public class SpellBreakHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpellBreakHelperApplication.class, args);
	}


	@Bean
    public Config getConfig(){
	    return new LiveConfig();
    }
}
