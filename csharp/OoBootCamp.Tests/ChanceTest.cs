/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

using System.Collections.Generic;
using NUnit.Framework;

namespace OoBootCamp.Tests
{
    // Ensures Chance operates correctly
    [TestFixture]
    public class ChanceTest
    {

        [Test]
        public void Equality()
        {
            Assert.AreEqual(new Chance(0.75), new Chance(0.75));
            Assert.AreNotEqual(new Chance(0.75), new Chance(0.25));
            Assert.AreNotEqual(new Chance(0.75), new object());
            Assert.AreNotEqual(new Chance(0.75), null);
        }

        [Test]
        public void HashSet()
        {
            Assert.True(new HashSet<Chance>() { new Chance(0.75) }.Contains(new Chance(0.75)));
            Assert.AreEqual(1, new HashSet<Chance>() { new Chance(0.75), new Chance(0.75) }.Count);
        }

        [Test]
        public void Hash()
        {
            Assert.AreEqual(new Chance(0.75).GetHashCode(), new Chance(0.75).GetHashCode());
        }
    }
}