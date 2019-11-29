package visual;
import java.awt.*;
import java.awt.SplashScreen;


public final class PantInicio {

    
    SplashScreen splash;
    
    final String [] texto = {
        "Cargando el programa",
        "Cargando cosas",
        "Terminando de cargar"
    };
    
    public void ScreenSplash(){
        splash = SplashScreen.getSplashScreen();
    }
    
    public void animar()
    {
        if (splash != null)
        {
            Graphics2D g = splash.createGraphics();
            for (int i = 1; i<texto.length; i++)
            {
                g.setColor(new Color(4,52,101));
                g.fillRect(203, 328, 280, 12);
                g.setColor(Color.white);
                g.drawString(texto[i], 203, 338);
                g.setColor(Color.green);
                g.fillRect(204, 308, (i*307/texto.length),12);
                float dash1 [] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.GREEN);
                g.setColor(new Color(4, 52, 101));
                g.drawLine(205, 314, 510, 314);
                g.drawLine(205, 314, 510, 314);
                splash.update();
                try {
                    Thread.sleep(321);
            }catch(InterruptedException e){}
            }
            splash.close();
        }
        try {
            Thread.sleep(4000);
            new Empresa_1().setVisible(true);
                               
            }catch (Exception e){
                System.out.println(e.getMessage());
        }
    }
    
}
