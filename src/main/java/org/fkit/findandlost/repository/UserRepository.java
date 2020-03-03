package org.fkit.findandlost.repository;

import org.fkit.findandlost.bean.FLUser;

import com.github.pagehelper.Page;

public interface UserRepository {
	/*	private int id;
		private String loginname;
		private String username;
		private String password;
		private String email;
		private String phone;
		private String qq;
		private String idcard;
		private char sex;
		private String clazz;
		private String role;
		private List<Goods> goods;*/
//	@Insert("insert into tb_user"
//			+ " (loginname,username,password,email,phone,qq,idcard,sex,clazz)"
//			+ " values"
//			+ " (#{loginname},#{username},#{password},#{email},#{phone},#{qq},#{idcard},#{sex},#{clazz})")
	public int insertUser(FLUser user);
	
	public int findU_id(FLUser user);
	
//	@Delete("delete from tb_user"
//			+ " where"
//			+ " u_id = #{u_id}")
	public int deleteUser(int id);
	
//	@Update("update tb_user"
//			+ " set"
//			+ " loginname = #{loginname},"
//			+ " username = #{username},"
//			+ " password = #{password},"
//			+ " email = #{email},"
//			+ " phone = #{phone},"
//			+ " qq = #{qq},"
//			+ " idcard = #{idcard},"
//			+ " sex = #{sex},"
//			+ " clazz = #{clazz}"
//			+ " where"
//			+ " u_id = #{u_id}")
	public int updateUser(FLUser user);
	
	
//	@Select("select * from tb_user")
//	@Results(id = "userResult",value = {
//			@Result(id = true,column = "u_id",property = "u_id"),
//			@Result(column = "loginname",property = "loginname"),
//			@Result(column = "username",property = "username"),
//			@Result(column = "password",property = "password"),
//			@Result(column = "email",property = "email"),
//			@Result(column = "phone",property = "phone"),
//			@Result(column = "qq",property = "qq"),
//			@Result(column = "idcard",property = "idcard"),
//			@Result(column = "sex",property = "sex"),
//			@Result(column = "clazz",property = "clazz"),
//			@Result(column = "role",property = "role")
//			//@Result(column = "goods",property = "id",many = @Many(select = ""))
//	})
//	public List<User> findAllUser();
	
//	@Select("select * from tb_user")
//	@ResultMap("userResult")
//	public Page<User> findUser();
	
	
//	@Select("select * from tb_user where u_id = #{u_id}")
//	@ResultMap("userResult")
	public FLUser findUserById(Integer id);
	
	public Page<FLUser> findUserBy(FLUser user);
	
	public FLUser findUserByLogin(FLUser user);
	
//	public FLUser findUserAll(int id);
	
	
//	@SelectProvider(type = UserDaoProvider.class, method = "findUserById")
//	@ResultMap("userResult")
//    public List<User> findUserByCount(User user);  
//      
//    class UserDaoProvider {  
//        public String findUserById(User user) {  
//            String sql = "select * from tb_user";
//            
//            if(user.getU_id() != null){  
//                sql += " where id = #{id}";  
//            }
//            if(user.getUsername() != null) {
//            	sql += "where username = #{username}";
//            }
//            if(user.getClazz() != null) {
//            	sql += "where clazz = #{clazz}";
//            }
//            return sql;  
//        }
//    }
}
