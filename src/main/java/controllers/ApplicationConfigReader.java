package controllers;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader {

public ApplicationConfigReader()
{
    PropertyLoader.newInstance().populate(this);
}


@Property(value = "Browser")    //Loading the value of Browser from property file
    private String Browser;

@Property(value = "URL")
    private String URL;

    public String getEndpoint() {
        return endpoint;
    }

    @Property(value = "Base_URI")
    private String Base_URI;

@Property(value = "endpoint")
    private String endpoint;

    @Property(value="API_key")
    private String apikey;

    @Property(value="City")
    private String city;

    @Property(value = "ImplicitlyWait")
private int ImplicitlyWait;

//Getter methods to get the values from property file
    public String getBrowser() {
        return Browser;
    }

    public String getURL() {
        return URL;
    }

    public String getBase_URI() {
        return Base_URI;
    }

    public int getImplicitlyWait() {
        return ImplicitlyWait;
    }

    public String getApikey()
    {
        return apikey;
    }

    public String getCity() {
        return city;
    }



}
