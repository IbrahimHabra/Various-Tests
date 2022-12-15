 public class Data {
     String name;
     int age;
     String email;
     public Data(){
         name = "";
         age = 0;
         email = "";
     }

     public Data(String name,int age,String email){
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
}
