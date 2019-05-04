/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

using System.Collections.Generic;
using NUnit.Framework;
using OoBootCamp.Quantities;

namespace OoBootCamp.Tests
{
    // Ensures Quantity operates correctly
    [TestFixture]
    public class QuantityTest
    {

        [Test]
        public void EqualityOfLikeUnits()
        {
            Assert.AreEqual(new Quantity(4, Unit.Tablespoon), new Quantity(4, Unit.Tablespoon));
            Assert.AreNotEqual(new Quantity(4, Unit.Tablespoon), new Quantity(6, Unit.Tablespoon));
            Assert.AreNotEqual(new Quantity(4, Unit.Tablespoon), new object());
            Assert.AreNotEqual(new Quantity(4, Unit.Tablespoon), null);
        }

        [Test]
        public void EqualityOfUnlikeUnits()
        {
            Assert.AreNotEqual(new Quantity(4, Unit.Tablespoon), new Quantity(4, Unit.Teaspoon));
        }

        [Test]
        public void HashSet()
        {
            Assert.True(new HashSet<Quantity>() { new Quantity(4, Unit.Tablespoon) }.Contains(new Quantity(4, Unit.Tablespoon)));
            Assert.AreEqual(1, new HashSet<Quantity>() { new Quantity(4, Unit.Tablespoon), new Quantity(4, Unit.Tablespoon) }.Count);
        }

        [Test]
        public void Hash()
        {
            Assert.AreEqual(new Quantity(4, Unit.Tablespoon).GetHashCode(), new Quantity(4, Unit.Tablespoon).GetHashCode());
        }
    }
}