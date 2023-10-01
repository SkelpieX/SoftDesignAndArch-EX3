public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Display display = new Display();
        CashRegister cashRegister = new CashRegister(database, display);

        cashRegister.scan("001");
        cashRegister.scan("002");
        cashRegister.scan("003"); 
        cashRegister.scan("004");
        cashRegister.scan("005");
        cashRegister.scan("006");
        cashRegister.scan("007");
        cashRegister.scan("008");
        cashRegister.scan("009");
        cashRegister.scan("010");
        cashRegister.scan("011");
        cashRegister.scan("012");

    }
}
