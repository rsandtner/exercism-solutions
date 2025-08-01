local BankAccount = {}

local function requirePositive(amount)
    if amount < 1 then
        return error("amount must be positive")
    end
end

local function requireOpen(account)
    if not account.open then
        return error("could not perform action on closed account")
    end
end

function BankAccount:new()
    local acc = {
        open = true,
        account_balance = 0,
    }
    self.__index = self
    return setmetatable(acc, self)
end

function BankAccount:balance()
    return self.account_balance
end

function BankAccount:deposit(amount)
    requireOpen(self)
    requirePositive(amount)
    self.account_balance = self.account_balance + amount
end

function BankAccount:withdraw(amount)
    requireOpen(self)
    requirePositive(amount)

    local account_balance = self.account_balance - amount
    if account_balance < 0 then
        return error("account can not be overdrawn")
    end

    self.account_balance = account_balance
end

function BankAccount:close()
    self.open = false
end


return BankAccount
