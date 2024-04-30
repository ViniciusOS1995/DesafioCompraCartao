import cartao.CartaoCredito;
import cartao.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o Limite do Cartão: ");
        double lm = leitor.nextDouble();
        var cartao = new CartaoCredito(lm);

        System.out.println("Deseja realizar um lançamento de compra?");
        System.out.println("Se sim digite 1 se não digite qualquer numero: ");
        int opc = leitor.nextInt();

        while (opc == 1){
            System.out.println("Digite o produto a ser lançado na compra: ");
            String pro = leitor.next();
            System.out.println("Digite o valor do produto: ");
            double vl = leitor.nextDouble();
            var compra = new Compra(pro, vl);
            if (cartao.getSaldo() > vl){
                System.out.println("Lançamento de compra realizado com sucesso!");
            }else {
                System.out.println("Saldo indisponivel para lançamento!");
            }
            if (cartao.getSaldo() == 0){
                System.out.println("Você utilizou todo o limite do cartão.");
            }
            cartao.lancaCompra(compra);
            System.out.println("Deseja realizar outro lançamento de compra?");
            System.out.println("Se sim digite 1 se não digite qualquer numero: ");
            opc = leitor.nextInt();
        }
        Collections.sort(cartao.getCompras());
        System.out.println("Operação finalizada!");
        System.out.println("Esses são os Produtos lançados: ");
        System.out.println(cartao.getCompras());
        System.out.println("Saldo restante: "+ cartao.getSaldo());

    }
}
