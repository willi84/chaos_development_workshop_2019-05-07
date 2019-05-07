/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

using System.Collections.Generic;
using ExtensionMethods;
using NUnit.Framework;

namespace OoBootCamp.Tests
{
    // Ensures Chance operates correctly
    [TestFixture]
    public class ChanceTest
    {
        private static readonly Chance Impossible = 0.Chance();
        private static readonly Chance Unlikely = 0.25.Chance();
        private static readonly Chance EquallyLikely = 0.5.Chance();
        private static readonly Chance Likely = 0.75.Chance();
        private static readonly Chance Certain = 1.Chance();

        [Test]
        public void Equality()
        {
            Assert.AreEqual(Likely, 0.75.Chance());
            Assert.AreEqual(Likely, 0.75.Chance());
            Assert.AreNotEqual(Likely, new object());
            Assert.AreNotEqual(Likely, null);
        }

        [Test]
        public void HashSet()
        {
            Assert.True(new HashSet<Chance>() { Likely }.Contains(0.75.Chance()));
            Assert.AreEqual(1, new HashSet<Chance>() { Likely, 0.75.Chance() }.Count);
        }

        [Test]
        public void Hash()
        {
            Assert.AreEqual(Likely.GetHashCode(), 0.75.Chance().GetHashCode());
        }

        [Test]
        public void Not()
        {
            Assert.AreEqual(Unlikely, !Likely);
            Assert.AreEqual(Likely, !!Likely);
            Assert.AreEqual(Likely, Likely.Not().Not());
            Assert.AreEqual(Impossible, !Certain);
            Assert.AreEqual(Certain, !Impossible);
            Assert.AreEqual(0.3.Chance(), !!0.3.Chance());
        }

        [Test]
        public void And()
        {
            Assert.AreEqual(Unlikely, EquallyLikely & EquallyLikely);
            Assert.AreEqual(0.1875.Chance(), Likely & Unlikely);
            Assert.AreEqual(Unlikely.And(Likely), Likely & Unlikely);
            Assert.AreEqual(Likely, Likely & Certain);
            Assert.AreEqual(Impossible, Impossible & Likely);
        }

        [Test]
        public void Or()
        {
            Assert.AreEqual(Likely, EquallyLikely | EquallyLikely);
            Assert.AreEqual(0.8125.Chance(), Likely | Unlikely);
            Assert.AreEqual(Unlikely.Or(Likely), Likely | Unlikely);
            Assert.AreEqual(Certain, Likely | Certain);
            Assert.AreEqual(Likely, Impossible | Likely);
        }
    }
}