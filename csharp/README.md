# oo_boot_camp_polyglot_reference_01

Copyright (c) 2019 by Fred George.
May be used freely except for training; license required for training.

C# reference implementation originally for Budapest workshop 7-8 May 2019

C# has two tool choices: Visual Studio and VS Code.

Tests are deliberately set up in a different project to encourage unit
testing of only the public interface to code.

## Visual Studio setup

Note: The original was setup to use Visual Studio 2019 - Community Edition.
JetBrains ReSharper was added. NUnit was used for unit testing.

Open the reference code:

- Download the source code from github.com/fredgeorge
  - Clone, or pull and extract the zip
- Open Visual Studio
- Choose "Open"
- Navigate to the reference code root, and enter

Source code will be in project OoBootCamp, and test code will be in
OoBootCamp.Tests.

Using NuGet, pull down NUnit and NUnit3TestAdapter, associating each with just
the OoBootCamp.Tests project.

Confirm that everything builds correctly (and necessary libraries exist), and
the initial tests pass.

## Original setup (avoid if possible!)

Create the solution and projects:

- Create a solution with project OoBootCamp as .Net library
- Add another project OoBootCamp.Tests as a .Net Unit Test library
- Using NuGet, install and associate with OoBootCamp.Tests:
  - NUnit
  - NUnit3TestAdapter
- Remove the generated stub .cs file from each project

If ReSharper is installed, tests can be written that speculate on the
existance of implementations in the other projects. ReSharper will prompt
for creating the proper dependency between the projects, and find the
implementations.

If ReSharper is not installed:

- Create a build dependency of OoBootCamp.Tests on OoBootCamp.
- Add a reference from OoBootCamp.Tests to OoBootCamp:
  - Under OoBootCamp.Tests, right click on References
  - Select Add Reference...
  - Select Projects on the left
  - Select OoBootCamp and click OK

At this point, tests should run from the VisualStudio Test Explorer.
