import org.junit.jupiter.api.Test
import CPIContext

class CPIContextTest {

    @Test
    void TESTGROUP() {

        CPIContext.MappingContext context= new CPIContext.MappingContext();

        //AB HIER KOPIEREN
        def strQuery= "ArticleHierachyName=Gem%C3%BCse&SomethingOthers=Blabla"
        def Paramters= strQuery.split("&");
        /*
             File file = new File("src/XMLFiles/BusinessPartnerReplication.xml");
        def root=  new XmlSlurper().parseText( file.getText('utf-8'))
        */

        println Paramters;
        def ItemCol=[: ];
        ItemCol["ArticleHierachyName"]="";
        ItemCol["ArticleHierarchyIDPath"]="";
        ItemCol["ArticleHierachyNode"]="";
        ItemCol["ArticleHierarchyNamePath"]="";
        Paramters.each { item ->
            def Item= item.split("=");
            ItemCol[Item[0]]=    Item[1]  ;
        }
        //   println ItemCol;
        def builder = new groovy.json.JsonBuilder();

        builder{
            Request{
                ArticleHierachyName  ItemCol["ArticleHierachyName"]
                ArticleHierarchyIDPath  ItemCol["ArticleHierarchyIDPath"]
                ArticleHierachyNode ItemCol["ArticleHierachyNode"]
                ArticleHierarchyNamePath ItemCol["ArticleHierarchyNamePath"]
            }

        }


        //BIS HIER
        println context.getProperty("MATL_CAT");
        println URLDecoder.decode( builder.toString(),"utf-8")
    }


}
