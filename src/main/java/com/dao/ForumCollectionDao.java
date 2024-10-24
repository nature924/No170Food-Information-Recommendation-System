package com.dao;

import com.entity.ForumCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ForumCollectionView;

/**
 * 论坛收藏 Dao 接口
 *
 * @author 
 */
public interface ForumCollectionDao extends BaseMapper<ForumCollectionEntity> {

   List<ForumCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
