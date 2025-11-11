package springFrameWork.bean;

/**
 *
 * @author Li Shuokang
 * @date 2025/11/9
 */
public class UserService {

    private String Uid;

    private UserDao userDao;

    public void queryUserInfo(){
        String name = userDao.queryUserName(Uid);
        System.out.println("用户id:"+Uid+" 对应的用户名:"+name);
    }
}
