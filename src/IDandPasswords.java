import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo=new HashMap<String,String>();
    IDandPasswords(){
        logininfo.put("123456","123456");
        logininfo.put("Pra","Chauhan");
        logininfo.put("Prave","chauhan");
        logininfo.put("1232","geggr");
        logininfo.put("Pravee","sdfg");
        logininfo.put("Praveen","Chauhan");
        logininfo.put("savirc","root");
    }
    protected HashMap getLoginInfo(){
        return logininfo;
    }
}
