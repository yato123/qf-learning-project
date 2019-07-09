package servlet;

import entity.GoodsInfo;
import entity.Page;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import service.IGoodsInfoService;
import service.IPage;
import service.Impl.GoodsInfoService;
import service.Impl.IPageImpl;
import userDao.userDaoImpl.GoodsInfoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class GoodsInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        IGoodsInfoService goodsService = new GoodsInfoService();
        IPage pageService = new IPageImpl();
        switch (action) {
            case "getPage":
                String currentPage = req.getParameter("currentPage");
                currentPage = currentPage == null?"1":currentPage;
                //调用service层获取page对象
                Page page = pageService.getPage(currentPage);
                req.setAttribute("page",page);
                req.getRequestDispatcher("queryall.jsp").forward(req,resp);
                break;
            case "insert":
                GoodsInfo goods = getGoods(req);
                if (goodsService.insert(goods)){
                    req.setAttribute("msg", "添加成功");
                    resp.sendRedirect("GoodsInfoServlet?action=getPage");
                } else {
                    req.setAttribute("msg", "添加失败");
                    req.getRequestDispatcher("insert.jsp").forward(req, resp);
                }
                break;

            case "update":
                Integer goodsInfo_id = Integer.valueOf(req.getParameter("goodsInfo_id"));
//                updateGoodsInfo(req, resp,goodsInfo_id);
                GoodsInfo goodsInfo = getGoodsUpdate(req, goodsInfo_id);
                if (goodsService.update(goodsInfo)) {
                    try {
                        req.setAttribute("msg", "修改成功....");
                        req.getRequestDispatcher("queryall.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        req.setAttribute("msg", "修改失败...");
                        req.getRequestDispatcher("update.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "delete":
                Integer id = Integer.valueOf(req.getParameter("id"));
//                delete(req, resp, id);
                if(goodsService.delete(id)){
                    try {
                req.setAttribute("msg", "删除成功");
                req.getRequestDispatcher("GoodsInfoServlet?action=getPage&currentPage=1").forward(req, resp);
                } catch (ServletException e) {
                e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
                }
                }else {
                    req.setAttribute("msg", "删除失败");
                    req.getRequestDispatcher("queryall.jsp").forward(req, resp);
                }
                break;


            case "query":
                resp.sendRedirect("queryall.jsp");
                break;

        }
    }

//    private void delete(HttpServletRequest req, HttpServletResponse resp, Integer id) {
//        if (1>2) {
//
//            try {
//                req.setAttribute("msg", "删除成功");
//                req.getRequestDispatcher("queryall.jsp").forward(req, resp);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }


    private void updateGoodsInfo(HttpServletRequest req, HttpServletResponse resp,Integer goodsInfo_id) {
        GoodsInfo goodsUpdate = getGoodsUpdate(req,goodsInfo_id);

        System.out.println(goodsUpdate);
        GoodsInfoDaoImpl goodsInfoDao = new GoodsInfoDaoImpl();
        if (goodsInfoDao.updateGoodsInfo(goodsUpdate) > 0) {

            try {
                req.setAttribute("msg", "修改成功....");
                req.getRequestDispatcher("queryall.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                req.setAttribute("msg", "修改失败...");
                req.getRequestDispatcher("update.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void insertGoodsInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsInfoDaoImpl goodsInfoDao = new GoodsInfoDaoImpl();
        GoodsInfo goods = getGoods(req);
        if (goodsInfoDao.insertGoodsInfo(goods) > 0) {
            req.setAttribute("msg", "添加成功");
            req.getRequestDispatcher("queryall.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "添加失败");
            req.getRequestDispatcher("insert.jsp").forward(req, resp);
        }


    }


    private GoodsInfo getGoods(HttpServletRequest req) {
        GoodsInfo goodsInfo = new GoodsInfo();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(req);
            HashMap<String, String> map = new HashMap();
            for (FileItem fItem : list) {
                if (!fItem.isFormField()) {
                    InputStream is = fItem.getInputStream();
                    String path = req.getServletContext().getRealPath("img");
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    UUID uuid = UUID.randomUUID();
                    String FileName = uuid.toString() + ".png";
                    FileOutputStream fos = new FileOutputStream(new File(path, FileName));
                    IOUtils.copy(is, fos);
                    is.close();
                    fos.close();
                    goodsInfo.setGoodsInfo_pic(FileName);
                } else {
                    String name = fItem.getFieldName();
                    String value = map.get(name);
                    if (value == null) {
                        map.put(name, fItem.getString("utf-8"));
                    } else {
                        map.put(name, value + "," + fItem.getString("utf-8"));

                    }
                }
            }
            goodsInfo.setGoodsInfo_name(map.get("goodsInfo_name"));
            goodsInfo.setGoodsInfo_price(Float.valueOf(map.get("goodsInfo_price")));
            goodsInfo.setGoodsInfo_description(map.get("goodsInfo_description"));
            goodsInfo.setGoods_stock(map.get("goods_stock"));


        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodsInfo;
    }

    private GoodsInfo getGoodsUpdate(HttpServletRequest req, Integer goodsInfo_id ) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = null;
        GoodsInfo goodsInfo = new GoodsInfo();
        try {
            HashMap<String, String> map = new HashMap<>();
            list = upload.parseRequest(req);
            for (FileItem fItem : list) {
                if (!fItem.isFormField()) {
                    InputStream is = fItem.getInputStream();
                    if (is.available() > 0) {
                        String path = req.getServletContext().getRealPath("img");
                        File file = new File(path);
                        if (file.exists()) {
                            file.mkdir();
                        }
                        UUID uuid = UUID.randomUUID();
                        String fileName = uuid.toString() + ".png";
                        FileOutputStream fos = new FileOutputStream(new File(path, fileName));
                        IOUtils.copy(is, fos);
                        fos.close();
                        is.close();
                        goodsInfo.setGoodsInfo_pic(fileName);
                    }
                } else {
                    String name = fItem.getFieldName();
                    String value = map.get(name);
                    if (value == null) {
                        map.put(name, fItem.getString("utf-8"));
                    } else {
                        map.put(name, value + "," + fItem.getString("utf-8"));
                    }
                }

            }
            goodsInfo.setId(goodsInfo_id);
            goodsInfo.setGoodsInfo_name(map.get("goodsInfo_name"));
            goodsInfo.setGoodsInfo_price(Float.valueOf(map.get("goodsInfo_price")));
            goodsInfo.setGoodsInfo_description(map.get("goodsInfo_description"));
            goodsInfo.setGoods_stock(map.get("goods_stock"));

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodsInfo;


    }


}
