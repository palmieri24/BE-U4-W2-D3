import it.epicode.be.Streams.Customers;
import it.epicode.be.Streams.Order;
import it.epicode.be.Streams.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        Product ioNonHoPaura = new Product("Io non ho paura", "Books", 17.50);
        Product harryPotter = new Product("Harry Potter", "Books", 29.99);
        Product ilPiacere = new Product("Il Piacere", "Books", 15.90);
        Product peluche = new Product("Peluche", "Baby", 19.99);
        Product bavaglino = new Product("bavaglino", "Baby", 8.99);
        Product tShirt = new Product("T-shirt", "Boys", 25.99);
        Product sneakers = new Product("Sneakers", "Boys", 149.99);
        Product calzini = new Product("calzini", "Boys", 9.99);
        productList.add(ioNonHoPaura);
        productList.add(harryPotter);
        productList.add(ilPiacere);
        productList.add(peluche);
        productList.add(bavaglino);
        productList.add(tShirt);
        productList.add(sneakers);
        productList.add(calzini);

        Customers annaRossi = new Customers("Anna Rossi");
        Customers marioBlu = new Customers("Mario Blu");
        Customers lucaVerdi = new Customers("Luca Verdi");
        Customers paoloGialli = new Customers("Paolo Gialli");

        List<Product> orderProductByAnnaR = new ArrayList<>();
        List<Product> orderProductByMarioB = new ArrayList<>();
        List<Product> orderProductByLucaV = new ArrayList<>();
        List<Product> orderProductByPaoloG = new ArrayList<>();

        orderProductByAnnaR.add(bavaglino);
        orderProductByAnnaR.add(ioNonHoPaura);

        orderProductByLucaV.add(peluche);
        orderProductByLucaV.add(ioNonHoPaura);


        orderProductByPaoloG.add(tShirt);
        orderProductByPaoloG.add(harryPotter);


        orderProductByMarioB.add(sneakers);
        orderProductByMarioB.add(ilPiacere);

        LocalDate date1 = LocalDate.of(2024, 1, 21);
        LocalDate date2 = LocalDate.of(2024, 2, 11);
        LocalDate date3 = LocalDate.of(2024, 6, 23);
        LocalDate date4 = LocalDate.of(2024, 9, 4);


        Order order1 = new Order("in progress", orderProductByAnnaR, annaRossi, date1);
        Order order2 = new Order("in progress", orderProductByMarioB, marioBlu, date2);
        Order order3 = new Order("in progress", orderProductByLucaV, lucaVerdi, date3);
        Order order4 = new Order("in progress", orderProductByPaoloG, paoloGialli, date4);


        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);


        List<Order> orderListCustomersTier2 = new ArrayList<>();
        LocalDate onefeb = LocalDate.of(2021, 2, 1);
        LocalDate oneApr = LocalDate.of(2021, 4, 1);


        System.out.println("-------------------EXERCISE 1-------------------");
        productList.stream().filter(product -> product.getCategory().equals("Books")).filter(product -> product.getPrice() > 100).forEach(System.out::println);
        System.out.println("-------------------EXERCISE 2-------------------");
        orderList.forEach(order -> order.getProducts().stream().filter(product -> product.getCategory().equals("Baby")).forEach(System.out::println));
        System.out.println("-------------------EXERCISE 3-------------------");
        productList.stream().filter(product -> product.getCategory().equals("Boys")).forEach(product -> product.setPrice(product.sconto(product.getPrice())));
        productList.stream().filter(product -> product.getCategory().equals("Boys")).forEach(System.out::println);
        System.out.println("-------------------EXERCISE 4-------------------");
        orderList.stream().filter(order -> order.getCustomers().getTier() == 2).forEach(orderListCustomersTier2::add);
        orderListCustomersTier2.stream().filter(order -> order.getOrderDate().isAfter(onefeb)).filter(order -> order.getOrderDate().isBefore(oneApr)).forEach(order -> System.out.println(order.getProducts().toString()));





    }
}