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
            Assert.AreNotEqual(4.Tablespoons(), 4.Teaspoons());
        }

        [Test]
        public void HashSet()
        {
            Assert.True(new HashSet<Quantity>() { 4.Tablespoons() }.Contains(4.Tablespoons()));
            Assert.AreEqual(1, new HashSet<Quantity>() { 4.Tablespoons(), 4.Tablespoons() }.Count);
        }

        [Test]
        public void Hash()
        {
            Assert.AreEqual(4.Tablespoons().GetHashCode(), 4.Tablespoons().GetHashCode());
        }
    }
}