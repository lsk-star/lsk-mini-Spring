package bean;


/**
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        String name = userDao.queryUserName(uId);
        System.out.println("用户id:"+uId+" 对应的用户名:"+name);
    }
}
