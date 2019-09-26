package JDBC_fengzhuangdiceng;

public class shuju {

    private Integer bianhao;
    private String name;
    private String password;

    public shuju() {
    }

    public shuju(Integer bianhao, String name, String password) {
        this.bianhao = bianhao;
        this.name = name;
        this.password = password;
    }

    public Integer getBianhao() {
        return bianhao;
    }

    public void setBianhao(Integer bianhao) {
        this.bianhao = bianhao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "shuju{" +
                "bianhao=" + bianhao +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
