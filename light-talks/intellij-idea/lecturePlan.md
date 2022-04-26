## Intellij Idea

1. Introduction
    1. Knowing features allows you to write better code and do it much faster
    2. Intellij Idea has lots of features, we can't go through them today, so I selected some of them that I use frequently
    3. All these features are present in Community edition, and this edition is enough for work
2. Live templates - <Demo_01> short abbreviations used for code generation
    1. `psvm`
    2. `fori`
    3. `sout`
3. Hot keys
    1. `Alt + Enter` - <Demo_01> context menu. It's items depend on the current code under the cursor
    2. `Ctrl + W` - selects the next valid expression in increasing sections.
    3. `Shift + F6` - renames variable, method, class. Also renames all uses of this item.
    4. `Ctrl + /` - comments or uncomments current line or selected text block
    5. `Ctrl + F` - search in current file
        1. Match case
        2. Words
        3. Regex
    6. `Ctrl + Alt + F` - search in all files
    7. `Shift + Shift` - search everywhere. Can be used to look for classes, folders, or IDE functions
        1. `ArrayList`
        2. Plugins
    8. `Ctrl + Alt + M` - <Demo_02> extract method. Also looks for code block duplicates and can replace them too
    9. `Ctrl + Alt + P` - extract argument
    10. `Ctrl + Alt + C` - extract constant
    11. `Ctrl + Alt + V` - <Demo_03> extract variable 
    12. `Ctrl + B` - go to definition. Depending on the current code opens either the declaration of varible or class, or method implementation
    13. `Alt + Insert` - <Demo_04> generates code. Usually is used to generate boilerplate for java beans
4. Debugging - <Demo_01>
    1. Why sout debugging doesn't work
        1. Not all code is editable
        2. Hard to read many souts
        3. Some code paths take to long to get to, and sout debugging requires many restarts of an app to add new souts
        4. Hands up everyone who used it at least once
    2. Simple debugging point - beginning of the `doComputations` method
        1. Debugging window - stacktrace, variables window, control pane
    3. Conditional point - `input == 0`
        1. Boolean condition
        2. N-th enter
        3. Expiring point 
5. Inspections
    1. Theory
        1. Static analysis of your code, which means that it uses only source files without running them
        2. There are many categories, some are enabled by default, some are disabled. You can change this setting, but defaults are reasonable
    2. Possible bugs - <Demo_01> string comparison with ==, when you should use `equals` method instead
    3. Performance <Demo_02> 
        1. bulk operation - they are faster than multiple operations with single element, because of possible internal optimizations
        2. string concat in loop
    4. Control flow - <Demo_03> redundant if
