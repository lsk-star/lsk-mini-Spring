package springFrameWork.bean;

/**
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
    }

    public void queryUserInfo(){
        if (name != null){
            System.out.println("查询用户信息：" + name);
        }
        System.out.println("查询用户信息");
    }
}
