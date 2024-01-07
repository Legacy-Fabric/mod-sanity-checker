#!/usr/bin/env bash


if [[ -z "$RUNCOMMAND" ]]; then
    echo "RUNCOMMAND is not set"
    exit 1
fi

if [[ -z "$RUNDIR" ]]; then
    echo "RUNDIR is not set"
    exit 1
fi

echo "copying files"
cp "sanitycheck.jar" "$RUNDIR/mods/sanitycheck.jar"

$RUNCOMMAND

if [[ $? -ne 0 ]]; then
    echo "command failed"
    exit 1
fi

if [[ -e "$RUNDIR/sane" ]]; then
    echo "sane file exists"
    exit 0
else
    echo "sane file does not exist"
    exit 1
fi
