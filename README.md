# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/pg-enum-usertype/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/pg-enum-usertype/actions/workflows/gradle.yml)
[![Build Status](https://travis-ci.org/astrapi69/pg-enum-usertype.svg?branch=master)](https://travis-ci.org/astrapi69/pg-enum-usertype)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/pg-enum-usertype.svg?style=flat)](https://github.com/astrapi69/pg-enum-usertype/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/pg-enum-usertype/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/pg-enum-usertype)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/pg-enum-usertype.svg)](http://www.javadoc.io/doc/io.github.astrapi69/pg-enum-usertype)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/pg-enum-usertype?branch=develop)](https://hitsofcode.com/github/astrapi69/pg-enum-usertype/view?branch=develop)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/pg-enum-usertype)](https://github.com/astrapi69/pg-enum-usertype)

</div>

This project holds the class PGEnumUserType for custom user type that maps string to enum and back.
Note: Can be used only with Postgres database and hibernate

## License

The source code comes under the liberal MIT License, making pg-enum-usertype great for all types of applications.

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/pg-enum-usertype" data-icon="octicon-star" aria-label="Star astrapi69/pg-enum-usertype on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## gradle dependency

You can first define the version in the ext section and add than the following gradle dependency
to your project `build.gradle` if you want to import the core functionality of pg-enum-usertype:

define version in file gradle.properties

```
pgEnumUsertypeVersion=1.1
```

or in build.gradle ext area

```
    pgEnumUsertypeVersion = "1.1"
```

and then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:pg-enum-usertype:$pgEnumUsertypeVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check out
[sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~pg-enum-usertype~~~)
for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of
pg-enum-usertype:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- PG-ENUM-USERTYPE version -->
        <pg-enum-usertype.version>1.1</pg-enum-usertype.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- PG-ENUM-USERTYPE DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>pg-enum-usertype</artifactId>
                <version>${pg-enum-usertype.version}</version>
            </dependency>
            ...
        </dependencies>

## Semantic Versioning

The versions of pg-enum-usertype are maintained with the Simplified Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning for this project you can visit this
[wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Simplified-Semantic-Versioning).

# Donations

This project is kept as an open source product and relies on contributions to remain being developed. If you like this
library, please consider a donation

over paypal: <br><br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this"
title="PayPal – The safer, easier way to pay online!" style="border: none" />
</a>
<br><br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over flattr:

<a href="http://flattr.com/thing/4067696/astrapi69pg-enum-usertype-on-GitHub" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" style="border: none" />
</a>

## Want to Help and improve it? ###

The source code for pg-enum-usertype are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/pg-enum-usertype/fork](https://github.com/astrapi69/pg-enum-usertype/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/pg-enum-usertype/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the pg-enum-usertype developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/pg-enum-usertype/issues).

## Note

No animals were harmed in the making of this library.

# Donations

If you like this library, please consider a donation through bitcoin or over bitcoin-cash with:

36JxRRDfRazLNqUV6NsywCw1q7TK38ukpC

or over ether with:

0x588Aa02De98B1Ef70afeDC3ec5290130a3E5e273

or over flattr:

<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Fastrapi69%2Fpg-enum-usertype" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" />
</a>

## Credits

|![sonatype repository](https://avatars1.githubusercontent.com/u/33330803?s=200&v=4)|
|Many thanks to [sonatype repository](https://oss.sonatype.org) for providing a free maven repository service for open source projects.|

|[![Javadoc](https://javadoc-emblem.rhcloud.com/doc/io.github.astrapi69/pg-enum-usertype/badge.svg)](http://www.javadoc.io/doc/io.github.astrapi69/pg-enum-usertype) pg-enum-usertype |
|Many thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects.|
