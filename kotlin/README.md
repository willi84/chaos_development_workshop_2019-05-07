# oo_boot_camp_polyglot_reference_01

Copyright (c) 2019 by Fred George.
May be used freely except for training; license required for training.

Kotlin reference implementation originally for Budapest workshop 7-8 May 2019

Kotlin is relatively easy to setup with IntelliJ IDEA. The following instructions are for installing
the code in IntelliJ 2019.1 by JetBrains. Adapt as necessary for your environment.

To test the external interfaces to classes, tests have been set up in a
separate module since Kotlin's scoping mechanism is at the module level, not
package level like Java.

## IntelliJ setup

Note: The original was setup to use Kotlin 1.3, Java SDK 11, and JUnit 5-style for testing.

Open the reference code:

- Download the source code from github.com/fredgeorge
  - Clone, or pull and extract the zip
- Open IntelliJ
- Choose "Open"
- Navigate to the reference code root, and enter

Source and test directories should already be tagged as such. Confirm or fix:

- File/Project Structure...
- Select "Modules"
  - Tag src directory as Sources in *exercises* module
  - Tag test directory as Tests in *tests* module
  - Click "OK"

Confirm that everything builds correctly (and necessary libraries exist)
