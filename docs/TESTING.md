# Testing Notes

The program was compiled and executed successfully with Java 21.

## Compilation

```bash
javac -Xlint:all src/banks/Main.java
```

Result: successful compilation with no compiler warnings.

## Verified flows

- Initial sample-account creation
- Correct customer login
- Invalid account/password rejection
- New account creation
- Duplicate account-number rejection
- Account search for an existing account
- Account search for a missing account
- Invalid and negative transaction amount handling
- Non-finite amount (`NaN`) rejection
- Successful deposit
- Insufficient-balance rejection
- Successful withdrawal
- Balance calculation: `1000 + 500 - 200 = 1300`
- Display of all 11 accounts after creating one new account
- Clean logout and program exit
- Saving account data to `bank_accounts.dat`
- Loading the saved account data after restarting the program
- Persistence of the final balance (`Rs. 1300.0`) after restart
