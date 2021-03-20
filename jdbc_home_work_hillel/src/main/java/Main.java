
import entity.Accounts;
import entity.Clients;
import entity.Status;
import service.AccountService;
import service.ClientService;
import service.StatusService;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        // READ Client -------------------------------------------------------------------------------------------------
        System.out.println(clientService.getAll());
        // UPDATE Client ------------------------------------------------------------------------------------------------
        Clients alex = new Clients("alex", "anotheralex@mail.com", null, 380981111111L, 6, 14);
        clientService.update(alex);
        System.out.println(clientService.getAll());
        // SAVE Client -------------------------------------------------------------------------------------------------
        Clients david = new Clients("David", "divid@mail.com", "first try save", 380950952311L, 11);
        clientService.save(david);
        System.out.println(clientService.getAll());
        // DELETE Client -----------------------------------------------------------------------------------------------
        clientService.delete(david);
        System.out.println(clientService.getAll());
        // FIND CLIENT WHERE PHONE -------------------------------------------------------------------------------------
        System.out.println(clientService.getByPhone(380981111111L));

        //READ Account -------------------------------------------------------------------------------------------------
        AccountService accountService = new AccountService();
        System.out.println(accountService.getAll());
        //UPDATE Account -----------------------------------------------------------------------------------------------
        Accounts accounts = new Accounts(1,1,"1000000001", 222300.5);
        accountService.update(accounts);
        System.out.println(accountService.getAll());
        // SAVE Account ------------------------------------------------------------------------------------------------
        Accounts newAccount = new Accounts(11, "200001001", 673.23);
        accountService.save(newAccount);
        System.out.println(accountService.getAll());
        // DELETE Account ----------------------------------------------------------------------------------------------
        accountService.delete(newAccount);
        System.out.println(accountService.getAll());
        // FIND Account WHERE value more -------------------------------------------------------------------------------
        System.out.println(accountService.getByValue(1000.0));
        // SELECT WITH JOIN ID -----------------------------------------------------------------------------------------
        System.out.println(accountService.getByIdAndClientId());

        // SELECT all statuses -----------------------------------------------------------------------------------------
        StatusService statusService = new StatusService();
        System.out.println(statusService.getAll());
        // UPDATE status -----------------------------------------------------------------------------------------------
        Status status = new Status(1, "LOW","Have standard card and max credit limit 1000, can use only LOW service");
        statusService.update(status);
        System.out.println(statusService.getAll());
        // SAVE status -------------------------------------------------------------------------------------------------
        Status statusStandard = new Status("STANDARD", "STANDARD can use LOW and STANDARD service");
        statusService.save(statusStandard);
        System.out.println(statusService.getAll());
        // DELETE status -----------------------------------------------------------------------------------------------
        statusService.delete(statusStandard);
        System.out.println(statusService.getAll());
        // JOIN 3th ----------------------------------------------------------------------------------------------------
        System.out.println(statusService.getJoinNameMailAlias());
    }
}
