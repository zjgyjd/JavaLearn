package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/fileUpload_1")
    public String fileUpload_1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传....");

        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //解析request对象,获得上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断当前对象是否是上传文件项,即是不是专门的文件表单
            if (item.isFormField()) {

            } else {
                String filename = item.getName();
                //把文件名称设置为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //完成文件上传
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();

            }
        }
        return "success";
    }

    @RequestMapping("/fileUpload_2")
    public String fileUpload_2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springMVC文件上传....");
        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        //把文件名称设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));
        return "success";

    }

    @RequestMapping("/fileUpload_3")
    public String fileUpload_3(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springMVC跨服务器文件上传....");
        //定义上传文件路径,注意要加最后的斜杠
        String path = "http://localhost:9090/uploads/";

        String filename = upload.getOriginalFilename();
        //把文件名称设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传,跨服务器上传
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";

    }
}

