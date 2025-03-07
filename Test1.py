import re

def is_valid_string(s):
    # Check if the string is at least 6 characters long
    if len(s) < 6:
        return False
    
    # Check for at least 2 but no more than 3 digits
    digit_count = len(re.findall(r'\d', s))
    if digit_count < 2 or digit_count > 3:
        return False
    
    # Check that each digit is separated by at least one non-digit character
    if re.search(r'\d{2,}', s):
        return False
    
    return True