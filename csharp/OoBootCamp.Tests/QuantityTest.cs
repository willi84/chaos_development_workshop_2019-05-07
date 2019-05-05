/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

using System.Collections.Generic;
using NUnit.Framework;
using OoBootCamp.Quantities;
using OoBootCamp.Quantities.ExtensionMethods;

namespace OoBootCamp.Tests
{
    // Ensures Quantity operates correctly
    [TestFixture]
    public class QuantityTest
    {

        [Test]
        public void EqualityOfLikeUnits()
        {
            Assert.AreEqual(4.Tablespoons(), 4.Tablespoons());
            Assert.AreNotEqual(4.Tablespoons(), 6.Tablespoons());
            Assert.AreNotEqual(4.Tablespoons(), new object());
            Assert.AreNotEqual(4.Tablespoons(), null);
        }

        [Test]
        public void EqualityOfUnlikeUnits()
        {
            Assert.AreEqual(6.Tablespoons(), 3.Ounces());
            Assert.AreEqual(8.Tablespoons(), 0.5.Cups());
            Assert.AreEqual(0.5.Cups(), 8.Tablespoons());
            Assert.AreEqual(2.Gallons(), 1536.Teaspoons());
            Assert.AreNotEqual(4.Tablespoons(), 4.Teaspoons());
        }

        [Test]
        public void HashSet()
        {
            Assert.True(new HashSet<Quantity>() { 4.Tablespoons() }.Contains(4.Tablespoons()));
            Assert.True(new HashSet<Quantity>() { 8.Tablespoons() }.Contains(0.5.Cups()));
            Assert.AreEqual(1, new HashSet<Quantity>() { 4.Tablespoons(), 4.Tablespoons() }.Count);
            Assert.AreEqual(1, new HashSet<Quantity>() { 8.Tablespoons(), 0.5.Cups() }.Count);
        }

        [Test]
        public void Hash()
        {
            Assert.AreEqual(4.Tablespoons().GetHashCode(), 4.Tablespoons().GetHashCode());
            Assert.AreEqual(8.Tablespoons().GetHashCode(), 0.5.Cups().GetHashCode());
        }
    }
}