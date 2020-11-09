package com.yg.sevlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成图片验证吗
 */
@WebServlet("/AuthImage")
public class AuthImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //阻止浏览器缓存静态资源（图片），每次必须最新   告诉浏览器你不要缓存图片（）
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0); //立马失效
        resp.setContentType("image/jpeg"); // text/html

        //图片大小                   r         g         b    r  g  b       0f（15） ---  00001111
        int width = 80; //宽度      0 0        00        00 - ff ff ff     16进制    8进制    0
        int height = 20; //高度   0000 0000   00000000   00000000          2进制     2进制   000
        //创建一个图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //图片中绘制内容
        Graphics g = image.getGraphics();
//        Random random = new Random();
        //设置当前颜色  生成随机的 new Color（r, g, b）
        g.setColor(getRandColor(200, 250));
        //填充矩形的颜色
        g.fillRect(1, 1, width - 1, height - 1);  // 1-80（width）  1-20（height）
        //设置颜色
        g.setColor(new Color(102, 102, 102));  //#666666
        //绘制矩形边框
        g.drawRect(0, 0, width - 1, height - 1);


        Random random = new Random();
        //设定线条颜色
        g.setColor(getRandColor(160, 200));
        //随机线条
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width - 1);  //0-79
            int y = random.nextInt(height - 1); //0-19
            int x1 = random.nextInt(6) + 1; // 1-7
            int y1 = random.nextInt(12) + 1; // 1-13
            g.drawLine(x, y, x + x1, y + y1);   // 两点连成一线   （x,y）- (x1,y1)
        }

        for (int i = 0; i < 70; i++) {
            int x = random.nextInt(width - 1); //0-79
            int y = random.nextInt(height - 1); //0-19
            int x1 = random.nextInt(12) + 1; // 1-13
            int y1 = random.nextInt(6) + 1;  // 1-7
            g.drawLine(x, y, x - x1, y - y1);
        }


        //设置字体的参数
        Font font = new Font("Arial Black", Font.PLAIN, 16);
        g.setFont(font);

        String sRand = "";
        //随机字符串加入图片中
        int LEN = 4; //长度
        for (int i = 0; i < LEN; i++) {  //有四个随机字符
            String tmp = getRandomChar(); //随机字符  A-Z  a-z  0-9
            sRand += tmp;  //sRand = sRand + tmp；  "****"
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(tmp, 15 * i + 10, 15);  //（10，15） （25，15） （40，15）  （55，15）
        }

        HttpSession session = req.getSession();
        //不区分大小写
        session.setAttribute("randomImageStr", sRand.toLowerCase());  //字符转小写
//        System.out.println(session.getAttribute("randomImageStr"));
        //关闭资源  connection.close();
        g.dispose();
        //响应到浏览器
        ImageIO.write(image, "JPEG", resp.getOutputStream());
    }

    /**
     * 随机颜色
     * @param fc
     * @param bc
     * @return
     */
    public Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        //      200           +              0 - 50
        int r = fc + random.nextInt(bc - fc);  //200 - 250    (0-255)
        int g = fc + random.nextInt(bc - fc);  //...
        int b = fc + random.nextInt(bc - fc);  //...
        return new Color(r, g, b);
    }

    /**
     * 返回随机字符  A-Z  a-z  0-9  随机一个字符
     * @return
     */
    public String getRandomChar() {
        // 0 1 2        1.2 --> 1 ( 0-2  double浮点型  *.*)
        int rand = (int)Math.round(Math.random() * 2);  //0-1      0-1.9999999  long 2
        long itmp = 0;      // itmp (long)  ==》 ctmp(char);
        char ctmp = '\u0000';
        switch (rand) {
            case 1:               // 0 - 25    + 65      65 - 90
                itmp = Math.round(Math.random() * 25 + 65);   //65-90
                ctmp = (char)itmp; // A-Z                     //65-90 --> char(字符)  A-Z
                return String.valueOf(ctmp);
            case 2:              // 0 - 25     + 97      97 - 122
                itmp = Math.round(Math.random() * 25 + 97);  //97-122
                ctmp = (char)itmp; //a-z                     //97-122 --> char(字符) a-z
                return String.valueOf(ctmp);
            default:
                itmp = Math.round(Math.random() * 9);  //不需要对照ASCII    0-9
                return String.valueOf(itmp);  // 0-9  String

        }
    }
}
