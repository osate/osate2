set -x

TODIR=/var/www/html/download/osate/testing
rm -fr ${TODIR}

mkdir -p ${TODIR}/products
cd releng/org.osate.build.product/target
cp products/*.zip ${TODIR}/products/.
cp products/*.tar.gz ${TODIR}/products/.

mkdir -p ${TODIR}/updates
cd ../../org.osate.build.repository/target
cp --recursive repository/* ${TODIR}/updates/.
ln -s ${TODIR}/updates ${TODIR}/update-site

mkdir -p ${TODIR}/code-coverage
cd ../../org.osate.build.coverage.report/target/site/jacoco-aggregate && cp --recursive * ${TODIR}/code-coverage/.
