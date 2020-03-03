package org.fkit.findandlost.repository;

import java.util.List;

import org.fkit.findandlost.bean.Goods;

import com.github.pagehelper.Page;

public interface GoodsRepository {
	/*	private int g_id;
		private String g_name;
		private String g_type;
		private String g_ltime;
		private String g_place;
		private String g_picture;
		private String g_rtime;
		private String g_title;
		private String g_status;
		private String g_describe;
		private String g_key;
		private int u_id;
		*/
//	@Insert("insert into tb_goods"
//			+ " (g_name,g_type,g_ltime,g_place,g_picture,g_rtime,g_title,g_status,g_describe,g_key,u_id)"
//			+ " values"
//			+ " (#{g_name},#{g_type},#{g_ltime},#{g_place},#{g_picture},#{g_rtime},#{g_title},#{g_status},#{g_describe},#{g_key},#{u_id})")
	public int insertGoods(Goods goods);
	
//	@Delete("delete from tb_goods"
//			+ " where"
//			+ " g_id = #{g_id}")
	public int deleteGoods(int id);
	
//	@Update("update tb_goods"
//			+ " set"
//			+ " g_name = #{g_name},"
//			+ " g_type = #{g_type},"
//			+ " g_ltime = #{g_ltime},"
//			+ " g_place = #{g_place},"
//			+ " g_picture = #{g_picture},"
//			+ " g_rtime = #{g_rtime},"
//			+ " g_title = #{g_title},"
//			+ " g_status = #{g_status},"
//			+ " g_describe = #{g_describe},"
//			+ " g_key = #{g_key},"
//			+ " u_id = #{u_id}"
//			+ " where"
//			+ " g_id = #{g_id}")
	public int updateGoods(Goods goods);
	
//	@Select("select * from tb_goods")
//	@Results(id = "goodsResult",value = {
//			@Result(column = "g_id",property = "g_id",id = true),
//			@Result(column = "g_name",property = "g_name"),
//			@Result(column = "g_type",property = "g_type"),
//			@Result(column = "g_ltime",property = "g_ltime"),
//			@Result(column = "g_title",property = "g_title"),
//			@Result(column = "g_status",property = "g_status"),
//			@Result(column = "g_describe",property = "g_describe"),
//			@Result(column = "g_key",property = "g_key"),
//			@Result(column = "g_place",property = "g_place"),
//			@Result(column = "g_rtime",property = "g_rtime"),
//			@Result(column = "g_picture",property = "g_picture"),
//			@Result(column = "u_id",property = "u_id")
//	})
	public Goods findGoodsById(int id);
	
	public Goods findOnlyGoods(int id);
	
//	@Select("select * from tb_goods where g_status = #{g_status} order by g_rtime")
//	@ResultMap("goodsResult")
	public Page<Goods> findGoodsByg_status(Goods goods);
	
	public List<Goods> findGoodsByUser(int id);
}
