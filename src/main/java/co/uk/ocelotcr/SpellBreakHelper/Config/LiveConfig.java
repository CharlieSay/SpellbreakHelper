package co.uk.ocelotcr.SpellBreakHelper.Config;

public class LiveConfig extends Config{

    @Override
    public String getDatabaseURL() {
        return "jdbc:mysql://127.0.0.1:3306";
    }

    @Override
    public String getDatabasePwd() {
        return "busted29";
    }

    @Override
    public String getDatabaseUsername() {
        return "root";
    }

}
