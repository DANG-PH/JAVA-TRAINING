package HelloJAR;
import HelloJAR.view.InvoiceView;
import HelloJAR.vn.edu.ptit.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DANGPH {

    static class PaymentController {
        private Invoice invoice;

        public PaymentController() {
            Scanner sc = new Scanner(System.in);

            Student msvVaTen = new Student(sc.nextLine(), sc.nextLine());

            int soMonHoc = Integer.parseInt(sc.nextLine());
            ArrayList<Subject> AlSubject = new ArrayList<>();

            for (int i = 0; i < soMonHoc; i++) {
                String code = sc.nextLine();
                String name = sc.nextLine();
                AlSubject.add(new Subject(name, code, Integer.parseInt(sc.nextLine())));
            }

            Rule rule = new Rule(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));

            invoice = new Invoice(rule);
            invoice.setSt(msvVaTen);
            invoice.setAlSubject(AlSubject);
            double hocPhi = 0;
            for (Subject sj : AlSubject) {
                hocPhi += sj.getCredit() * rule.getCreditPrice();
            }
            invoice.setAmount(hocPhi);
        }

        public Invoice getInvoice() {
            return invoice;
        }

    }
    public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}
