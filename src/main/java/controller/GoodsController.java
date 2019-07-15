package controller;

import entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IPage;
import service.Impl.IPageImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IPageImpl goodsPage;

    @RequestMapping("/goodsPage")
    public ModelAndView goodsPage(HttpServletRequest request) {
        System.out.println(request.toString());
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(111);
        String viewName = "queryall";
        Page page = goodsPage.getPage("1");
        System.out.println(page.getList().toString());
        modelAndView.addObject("page", page);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(String fileName, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(fileName);
        System.out.println(file.getOriginalFilename());
        if (null != file) {
//            String toPath = "D:\\File\\zilonglove\\target\\zilong-love\\images\\img\\" + fileName + file.getOriginalFilename();
            String toPath = request.getServletContext().getRealPath("img") + fileName + file.getOriginalFilename();
            System.out.println(toPath);
            System.out.println(request.getServletContext().getRealPath("img"));
            File toFile = new File(toPath);
            if (!toFile.exists()) {
                toFile.mkdirs();
            }
            //将file 复制到toFile
            file.transferTo(toFile);
        }
        return "login";
    }



}
