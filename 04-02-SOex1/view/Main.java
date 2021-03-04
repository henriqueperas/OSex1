package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		int opc_menu = 0;
        do{
            opc_menu = Integer.parseInt(JOptionPane.showInputDialog("                   MENU PRINCIPAL\n\n 1- ip\n 2- ping\n 0- Sair\n\n"));
            switch (opc_menu){
                case 1: ip(); break;
                case 2: ping(); break;
                case 0: JOptionPane.showMessageDialog(null, "Sistema Finalizado!","Finalizado",JOptionPane.INFORMATION_MESSAGE); break;
                default: JOptionPane.showMessageDialog(null, "Opção Inválida para o Menu Principal.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }while (opc_menu != 0);
		
	}
	static void ip(){
		RedesController redeController = new RedesController();
        String process = "ipconfig";
		redeController.ipread(process);
		String config;
	    StringBuilder mensagem = new StringBuilder();
	    config = JOptionPane.showInputDialog("Digite aqui a configuração:");
	    String str = config;
		String[] s1 = str.split("IPv4");
		String[] s2 = str.split("Gateway");
		int[] s3 = new int[s1.length];
		int[] s4 = new int[s2.length];
		for(int i = 1; i < s3.length; i++) {
			int posOfSubstr = str.indexOf(s1[i]);
			mensagem.append(str.substring((posOfSubstr + 32), (posOfSubstr + 50)));
		}
		for(int i = 3; i < s4.length; i++) {
			int posOfSubstr = str.indexOf(s2[i]);
			mensagem.append(str.substring((posOfSubstr + 117), (posOfSubstr + 130)));
		}
	    JOptionPane.showMessageDialog(null, mensagem);
    }
	
	static void ping(){
		RedesController redeController = new RedesController();
        String process = "ping -n 10 www.google.com";
		redeController.ipread(process);
    }
}
