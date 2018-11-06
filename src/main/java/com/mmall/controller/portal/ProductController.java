package com.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.vo.ProductDetailVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVO> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    @RequestMapping(value = "{productId}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<ProductDetailVO> detailRESTful(@PathVariable Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    @RequestMapping("list.do")
    @ResponseBody //springmvc数据绑定
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false)String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }

    //http://www.imoocx.com/product/手机/100012/1/10/price_asc
    @RequestMapping(value = "{keyword}/{categoryId}/{pageNum}/{pageSize}/{orderBy}", method = RequestMethod.GET)
    @ResponseBody //RESTful资源定位
    public ServerResponse<PageInfo> listRESTful(@PathVariable(value = "keyword")String keyword,
                                         @PathVariable(value = "categoryId") Integer categoryId,
                                         @PathVariable(value = "pageNum") Integer pageNum,
                                         @PathVariable(value = "pageSize") Integer pageSize,
                                         @PathVariable(value = "orderBy") String orderBy) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        if (StringUtils.isBlank(orderBy)) {
            orderBy = "price_asc";
        }
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }

    @RequestMapping(value = "{categoryId}/{pageNum}/{pageSize}/{orderBy}", method = RequestMethod.GET)
    @ResponseBody //RESTful资源定位
    public ServerResponse<PageInfo> listRESTfulBadcase(
                                                @PathVariable(value = "categoryId") Integer categoryId,
                                                @PathVariable(value = "pageNum") Integer pageNum,
                                                @PathVariable(value = "pageSize") Integer pageSize,
                                                @PathVariable(value = "orderBy") String orderBy) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        if (StringUtils.isBlank(orderBy)) {
            orderBy = "price_asc";
        }
        return iProductService.getProductByKeywordCategory("", categoryId, pageNum, pageSize, orderBy);
    }

    @RequestMapping(value = "{keyword}/{pageNum}/{pageSize}/{orderBy}", method = RequestMethod.GET)
    @ResponseBody //RESTful资源定位
    public ServerResponse<PageInfo> listRESTfulBadcase(
            @PathVariable(value = "keyword") String keyword,
            @PathVariable(value = "pageNum") Integer pageNum,
            @PathVariable(value = "pageSize") Integer pageSize,
            @PathVariable(value = "orderBy") String orderBy) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        if (StringUtils.isBlank(orderBy)) {
            orderBy = "price_asc";
        }
        return iProductService.getProductByKeywordCategory(keyword, null, pageNum, pageSize, orderBy);
    }

    @RequestMapping(value = "category/{categoryId}/{pageNum}/{pageSize}/{orderBy}", method = RequestMethod.GET)
    @ResponseBody //RESTful资源定位
    public ServerResponse<PageInfo> listRESTful(
            @PathVariable(value = "categoryId") Integer categoryId,
            @PathVariable(value = "pageNum") Integer pageNum,
            @PathVariable(value = "pageSize") Integer pageSize,
            @PathVariable(value = "orderBy") String orderBy) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        if (StringUtils.isBlank(orderBy)) {
            orderBy = "price_asc";
        }
        return iProductService.getProductByKeywordCategory("", categoryId, pageNum, pageSize, orderBy);
    }

    @RequestMapping(value = "keyword/{keyword}/{pageNum}/{pageSize}/{orderBy}", method = RequestMethod.GET)
    @ResponseBody //RESTful资源定位
    public ServerResponse<PageInfo> listRESTful                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       (
            @PathVariable(value = "keyword") String keyword,
            @PathVariable(value = "pageNum") Integer pageNum,
            @PathVariable(value = "pageSize") Integer pageSize,
            @PathVariable(value = "orderBy") String orderBy) {

        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageNum = 10;
        }
        if (StringUtils.isBlank(orderBy)) {
            orderBy = "price_asc";
        }
        return iProductService.getProductByKeywordCategory(keyword, null, pageNum, pageSize, orderBy);
    }

}
