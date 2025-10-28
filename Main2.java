public class Main2 {
    public static void main(String[] args) {
        Famous_People fp1 = new Famous_People();
        Famous_People fp2 = new Famous_People();
        Famous_People fp3 = new Famous_People();
        
        fp1.setNames("Cristiano Ronaldo");
        fp2.setNames("Di Caprio");
        fp3.setNames("Elon Musk");
        System.out.println(fp1.getNames());

         Service s1 = new Service();

         s1.setName(fp1.getNames());
         s1.sdelatBolshimi();
         s1.sdelatMalenkimi();
         s1.udalitProbel();

         Service s2 = new Service();
        s2.setName(fp2.getNames());
        s2.sdelatBolshimi();
        s2.sdelatMalenkimi();
        s2.udalitProbel();

        Service s3 = new Service();
        s3.setName(fp3.getNames());
        s3.sdelatBolshimi();
        s3.sdelatMalenkimi();
        s3.udalitProbel();


    }  
}

class Famous_People{
    
    private String award;
    private String country;
    private String names;
    private int age;

    public String getNames(){return names;}
    public void setNames(String str){
        names = str;
    }
    public int getAge(){return age;}
    public void setAge(int str){
        age = str;
    }

    public String getCountry(){return country;}
    public void setCountry(String str){
        country = str;
    } 

    public String getAward(){return award;}
    public void setAward(String str){
        award = str;
    }
}

class Service{

    private String name;

    public String getName(){return name;}
    public void setName(String str){
        name = str;
    }

    public void sdelatBolshimi(String name){
        String rezultat = "";
        for(int i=0; i<name.length(); i++){
            char simvol = name.charAt(i);
            if(simvol>='a' && simvol<='z'){
                simvol = (char)(simvol - 32);
            }
            rezultat = rezultat + simvol;
        }
        System.out.println(rezultat);
    }

    public void sdelatMalenkimi(){
        String rezultat = "";
        for(int i=0; i<name.length(); i++){
            char simvol = name.charAt(i);
            if(simvol>='A' && simvol<='Z'){
                simvol = (char)(simvol + 32);
            }
            rezultat = rezultat + simvol;
        }
        System.out.println(rezultat);
    }

    public void udalitProbel(){
        String rezultat = "";
        for(int i=0; i<name.length(); i++){
            char simvol = name.charAt(i);
            if(simvol != ' '){ 
                rezultat = rezultat + simvol;
            }
        }
        System.out.println(rezultat);
    }
}