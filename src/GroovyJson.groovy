import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.*;
def Message processData(Message message) {
    //Body
    def body = message.getBody();
    def jsonSlurper = new JsonSlurper();
    body =
            "{"+
        "\"zuweisungLayoutbaustein\""+": [{"+
            "\"frame_group_id\""+": 1,"+
            "\"store_codes\""+": 2"+
        "}]"+ "}";

    def list = jsonSlurper.parseText(body);
    def targetJson =[
            "zuweisungLayoutbaustein":
                    list.zuweisungLayoutbaustein
                            .collect {
                                u ->
                                    [   "frame_group_id": u.frame_group_id ,
                                        "store_codes" : u.store_codes
                                    ]
                            }
    ]
    def builder = new JsonBuilder(targetJson)
    builder = JsonOutput.prettyPrint(builder.toString())
    message.setBody(builder);


    return message;
}
