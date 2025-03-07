import re
from collections import Counter

def count_word_frequencies(text):
    # Convert text to lowercase
    text = text.lower()
    
    # Remove punctuation using regular expressions
    text = re.sub(r'[^\w\s]', '', text)
    
    # Split text into words
    words = text.split()
    
    # Count the frequency of each word
    word_counts = Counter(words)
    
    # Sort words by frequency in descending order
    sorted_word_counts = sorted(word_counts.items(), key=lambda item: item[1], reverse=True)
    
    return sorted_word_counts

# Example input
text = "Hello world! This is a test. Hello, this test is only a test."

# Get word frequencies
word_frequencies = count_word_frequencies(text)

# Display the word frequencies
print("Word Frequencies:")
for word, count in word_frequencies:
    print(f"{word}: {count}")
