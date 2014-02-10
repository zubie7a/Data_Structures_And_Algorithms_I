package practicadatos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
public class pnVista extends JComponent implements Observer, MouseMotionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	public Arbol j;
	private int found;
	private Image image ;
	private boolean busco;
	public boolean press;
	public Nodo encontrado;
	public int niv;
	public int preniv;
	public int hor;
    public int contn;
    public int prev;
    public int hox;
    public int X;
    public int Y;
    public int xx;
    public int yy;
    public int x1;
    public int y1;

    public int lav;
    public int[] par;
    public int[] par2;
    public URL url;

    public pnVista() {
    	niv = 0;
    	hor = 0;
    	lav = 0;
    	contn = 0;
    	prev = 0;
    	X=0;
    	Y=0;
    	xx=0;
    	yy=0;
    	x1=0;
    	y1=0;
    	par = new int [4];
    	par2 = new int[4];
        initComponents();
        busco = false;
        press = false;
        addMouseListener(this);
        addMouseMotionListener(this);
        try {
			  url = new URL("http://i39.tinypic.com/111m3jp.png");
		  }
		  catch (MalformedURLException e) {}
		  
		  try {
			image = ImageIO.read(url);
		  }
		  catch (IOException e) {}
		  
    }
    
    private void initComponents() {
        javax.swing.GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
    
    public void update(Observable o, Object arg) {
        j = (Arbol)arg;
        paintImmediately(0,0,20000,20000);
    }

    public void paint(Graphics g) {
        super.paint(g);
		g.drawImage(image, 0, 0, null);
        Nodo x;        
        hox = this.getSize().width/2;
        par = new int[4];
        par2 = new int[4];
        niv = 0;
    	hor = 0;
    	contn = 0;
    	prev = 0;
        ArrayList<Integer> nods = new ArrayList<Integer>();
        Map <Integer, Integer> pintados = new TreeMap<Integer,Integer>();
        Map <Integer,int[]> cosa = new TreeMap<Integer,int[]>();
        Map <Integer,int[]> cosa2 = new TreeMap<Integer,int[]>();
        ArrayList <Nodo> cola = new ArrayList<Nodo>(); 
        if(j!=null){
	        cola = j.recorrerPorNiveles();
	        for(int z=0,y=0,w=0;z<cola.size();++z){
	        	if(cola.get(z).level==y){
	        		w++;
	        	}
	        	if(cola.get(z).level!=y || z+1==cola.size()){
	        		nods.add(w);
	        		y++;
	        		w=0;
	        		if(z+1!=cola.size()){
	        			z--;
	        		}
	        	}
	        }
	        for(int y=0,f=0;y<cola.size();++y){
	            par = new int[4];
	            par2 = new int[4];
	        	x = cola.get(y);
            	contn=nods.get(x.level);
            	if(x.level==f){
            		for(int j=0,i;j<x.getValores().size();++j){
            			i=x.getValores().get(j);
            			g.setColor(Color.black);
            			g.fillRect(hox+hor-contn*50+prev+2+X, 90+niv-2+Y, Integer.toString(i).length()*10+4, 23);
            			lav += Integer.toString(i).length()*10+4;
            			if(busco==true && i==found){
            				g.setColor(Color.red);
            				g.fillRect(hox+hor-contn*50+prev+4+X, 90+niv+Y, Integer.toString(i).length()*10, 20);
            				g.setColor(Color.white);
            				g.drawString(Integer.toString(i),hox+hor-contn*50+prev+4+X, 102+niv+Y);
            			}
            			else{
            				g.setColor(Color.yellow);
    	            		g.fillRect(hox+hor-contn*50+prev+4+X, 90+niv+Y, Integer.toString(i).length()*10, 20);
                			g.setColor(Color.black);
                			g.drawString(Integer.toString(i),hox+hor-contn*50+prev+4+X, 102+niv+Y);
            			}
            			g.setColor(Color.white);
            			if(cosa.get(i)==null){
            				par = new int[4];
            				cosa.put(i,par);
            			}
            			par = cosa.get(i);
            			par[0]=hox+hor-contn*50+prev+2+X;
            			par[1]=90+niv-2+23+Y;
            			cosa.put(i,par);
            			prev += Integer.toString(i).length()*10;
            			if((j+1)==x.getValores().size()){
            				par2[0]=hox+hor-contn*50+prev+5+X;
                			par2[1]=90+niv-2+22+Y;
                			cosa2.put(i,par2);
            				for(int m=0;m<cola.size();++m){
                   				if(cola.get(m).esHijo(x)==true){
            						for(int r=0,q;r<cola.get(m).getValores().size();++r){
            							q=cola.get(m).getValores().get(r);
            							if(x.getValores().get(0)<q && pintados.get(x.getValores().get(0))==null){
            								par=cosa.get(q);
            								par[2]=hox+hor-contn*50+prev+2+X-lav/2;
            								par[3]=90+niv-2+Y; 
            	               				g.drawLine(par[0], par[1], par[2], par[3]);
            	               				pintados.put(x.getValores().get(0),1);
            							}
            							if(r+1==cola.get(m).getValores().size() && x.getValores().get(0)>q){
            								par2 = cosa2.get(q);
           									par2[2]=hox+hor-contn*50+prev+2+X-lav;
           									par2[3]=90+niv-2+Y;
           	                				g.drawLine(par2[0], par2[1], par2[2], par2[3]);
           								}
            						}
            					}
            				}
            			}
            			lav=0;
            		}
	        		hor+=180/j.getOrden()+20;
            	}
            	else{
            		preniv = niv;
            		niv = nods.get(x.level)*10;
            		if(niv-preniv<90){
            			niv += 90- (niv - preniv);
            		}
           			f++;
           			y--;
            		hor=0;
            		prev=0;
            	}
	        }
        }
        
    }
	public void setEncontrado(Nodo nod, int valor) {
		this.encontrado = nod;
		this.found = valor;
		busco = true;
		paintImmediately(0,0,20000,20000);
		busco = false;
	}

	public void mouseEntered(MouseEvent e){}
	public void  mouseExited(MouseEvent e){}  
	public void mouseClicked(MouseEvent e){}

	public void mousePressed(MouseEvent e){
		press=true;
	}
	
	public void mouseReleased(MouseEvent e){
		press=false;
    }
	
	public void mouseMoved(MouseEvent event) {
		if(press==true){
			xx = (int) event.getPoint().getX();
			yy = (int) event.getPoint().getY();
			if(xx>=0&&xx<=this.getSize().width && yy>=0&&yy<=this.getSize().height){
				if(yy>y1){
					Y+=(yy-y1);
				}
				if(yy<y1){
					Y-=(y1-yy);
				}
				if(xx>x1){
					X+=(xx-x1);
				}
				if(xx<x1){
					X-=(x1-xx);
				}
				repaint();
				x1 = xx;
				y1 = yy;
			}
		}
		else{
			y1 = (int) event.getPoint().getY();
			x1 = (int) event.getPoint().getX();
		}
		
	}
	
	public void mouseDragged(MouseEvent event) {
		 mouseMoved(event);
	}
	
	  
}

