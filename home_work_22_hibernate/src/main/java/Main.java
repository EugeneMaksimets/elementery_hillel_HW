import entity.Account;
import entity.Client;
import entity.Status;
import service.AccountService;
import service.ClientService;
import service.StatusService;

public class Main {
    public static void main(String[] args) {
        // CLIENT_SERVICE ----------------------------------------------------------------------------------------------
        ClientService clientService = new ClientService();
        // SAVE --------------------------------------------------------------------------------------------------------
        Client client = new Client("Maria", "maria@mail.com", 380919229123L,
                "new client Maria", 20);
        clientService.save(client);
        // UPDATE ------------------------------------------------------------------------------------------------------
        client.setId(17);
        client.setAge(18);
        client.setEmail("nemaria@ukr.net");
        clientService.update(client);
        // DELETE ------------------------------------------------------------------------------------------------------
        client.setId(17);
        clientService.delete(client);
        // GET_BY_ID ---------------------------------------------------------------------------------------------------
        Client clientWithIdOne = clientService.getById(1);
        System.out.println(clientWithIdOne);
        // GET_BY_PHONE ------------------------------------------------------------------------------------------------
        System.out.println(clientService.getByPhone(380986717294L));

        // ACCOUNT_SERVICE ---------------------------------------------------------------------------------------------
        AccountService accountService = new AccountService();
        // SAVE --------------------------------------------------------------------------------------------------------
        Account account = new Account(12, "33322211", 302.2);
        accountService.save(account);
        // UPDATE ------------------------------------------------------------------------------------------------------
        account.setId(14);
        account.setValue(25.33);
        account.setNumber("11122213");
        accountService.update(account);
        // DELETE ------------------------------------------------------------------------------------------------------
        accountService.delete(account);
        // GET_BY_ID ---------------------------------------------------------------------------------------------------
        Account accountWithIdOne = accountService.getById(1);
        System.out.println(accountWithIdOne);

        // STATUS_SERVICE ----------------------------------------------------------------------------------------------
        StatusService statusService = new StatusService();
        // SAVE -----------------------------------------------------------------------------
        Status status = new Status("Standard", "Can use STANDARD and LOW service");
        statusService.save(status);
        // UPDATE ------------------------------------------------------------------------------------------------------
        status.setId(7);
        status.setAlias("STANDARD");
        statusService.update(status);
        // DELETE ------------------------------------------------------------------------------------------------------
        statusService.delete(status);
        // GET_BY_ID ---------------------------------------------------------------------------------------------------
        Status statusWithIdOne = statusService.getById(1);
        System.out.println(statusWithIdOne);
    }
}
