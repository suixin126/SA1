
import weather.*;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
        WeatherWS weatherWS = new WeatherWSLocator();

        WeatherWSSoap_PortType stub = new WeatherWSSoap12Stub();

        stub = weatherWS.getWeatherWSSoap(new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx"));;
        String[] s = stub.getWeather("北京","");
        for(int i = 0; i < s.length; i ++){
            System.out.println(s[i]);
        }
    }
}
