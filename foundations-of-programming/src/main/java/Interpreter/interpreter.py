import re


def interpret(value, commands, args):
    result = value
    for i in range(len(commands)):
        match = re.match('[-+*]', commands[i], re.M | re.I)
        if match:
            result = operation(commands[i], result, args[i])
        else:
            return -1
    return result


def operation(command, value1, value2):
    if command == '+':
        return value1 + value2
    elif command == '-':
        return value1 - value2
    elif command == '*':
        return value1 * value2
    else:
        return -1
