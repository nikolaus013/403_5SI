package com.trasnformator.transform.bootstrap;


import com.trasnformator.transform.service.ServiceImpl.CRUD_ServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
CRUD_ServiceImpl impl = new CRUD_ServiceImpl();

 /*public void initData(){

     JSONObject test = new JSONObject();
     test.put("Ime","Mirko");
     String kolekcija = "Student";

    impl.createEntitet("Student");
   impl.saveEntitet(kolekcija,test);
     System.out.println("Uspesno");

 }
*/

    public void test(){

      impl.readEntitet("test");

    }


    @Override
    public void run(String... args) throws Exception {
    //initData();
        test();
    }
}
