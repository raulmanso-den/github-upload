class CPIContext {
    class MappingContext{
        //Define Propertiers
        def Properties=[MATL_CAT:"01",MATL_GROUP:"Y2015-07",CHAR_PROF:"Y_VC006",MATERIAL_CODE:"Y-KPS-00403", MATL_GROUP:"Y2015-07",additionalValueExists:"false" ];
        def Header= [MATL_CAT:"01",MATL_GROUP:"Y2015-07",CHAR_PROF:"Y_VC006",MATERIAL_CODE:"Y-KPS-00403", MATL_GROUP:"Y2015-07",additionalValueExists:"false" ];

        def String getProperty(String key) {
            if(key.contains("_XML")) {
                File file = new File("src/XMLFiles/"+key+".xml");
                return file.getText('utf-8')
            }else {
                return Properties[key];
            }
        }
        def String getHeader(String key) {
            if(key.contains("_XML")) {
                File file = new File("src/XMLFiles/"+key+".xml");
                return file.getText('utf-8')
            }else {
                return Header[key];
            }

        }
    }
    class Message{

        def String setMessage(String Message) {
            return Message;

        }
    }

}
