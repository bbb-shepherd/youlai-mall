package com.fly4j.shop.goods.pojo.dto;

import com.fly4j.shop.goods.pojo.entity.Goods;
import com.fly4j.shop.goods.pojo.entity.GoodsAttributeValue;
import com.fly4j.shop.goods.pojo.entity.GoodsFullReduction;
import com.fly4j.shop.goods.pojo.entity.GoodsLadder;
import com.fly4j.shop.goods.pojo.entity.GoodsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * @description: 商品添加的参数
 * @author: Mr.
 * @create: 2020-03-14 14:13
 **/
@Data
public class GoodsDTO extends Goods {
    /**
     * 商品阶梯价格设置
     */
    private List<GoodsLadder> goodsLadderList;
    /**
     * 商品满减价格设置
     */
    private List<GoodsFullReduction> goodsFullReductionList;
    /**
     * 商品的sku库存信息
     */
    private List<GoodsSkuStock> skuStockList;
    /**
     * 商品参数及自定义规格属性
     */
    private List<GoodsAttributeValue> goodsAttributeValueList;

    //商品所选分类的父id
    private Integer cateParentId;
}
